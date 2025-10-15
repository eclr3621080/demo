package org.example.warehousemanagersystem.service.order.service.Impl;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.apache.commons.lang3.StringUtils;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.assess.bo.AssessGetBO;
import org.example.warehousemanagersystem.service.assess.service.AssessService;
import org.example.warehousemanagersystem.service.assess.vo.AssessGetVO;
import org.example.warehousemanagersystem.service.customer.bo.CustomerGetBO;
import org.example.warehousemanagersystem.service.customer.mapper.CustomerMapper;
import org.example.warehousemanagersystem.service.customer.vo.CustomerVO;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeBO;
import org.example.warehousemanagersystem.service.gamestype.bo.GameTypeUpdateBO;
import org.example.warehousemanagersystem.service.gamestype.service.GameTypeService;
import org.example.warehousemanagersystem.service.gamestype.vo.GameTypeVO;
import org.example.warehousemanagersystem.service.goods.mapper.GoodsMapper;
import org.example.warehousemanagersystem.service.order.bo.OrderAddBO;
import org.example.warehousemanagersystem.service.order.bo.OrderGetBO;
import org.example.warehousemanagersystem.service.order.bo.OrderUpdateBO;
import org.example.warehousemanagersystem.service.order.enums.OrderStatusEnums;
import org.example.warehousemanagersystem.service.order.mapper.OrderMapper;
import org.example.warehousemanagersystem.service.order.pojo.OrderPOJO;
import org.example.warehousemanagersystem.service.order.service.OrderService;
import org.example.warehousemanagersystem.service.order.vo.OrderGetVO;
import org.example.warehousemanagersystem.service.peiwan.bo.PeiWanGetBO;
import org.example.warehousemanagersystem.service.peiwan.bo.PeiWanUpdateBO;
import org.example.warehousemanagersystem.service.peiwan.service.PeiWanService;
import org.example.warehousemanagersystem.service.peiwan.vo.PeiWanGetVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-09
 * @Description:
 * @Version: 1.0
 */

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    PeiWanService peiWanService;
    @Autowired
    GameTypeService gameTypeService;
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    SimpMessagingTemplate messagingTemplate;
    @Autowired
    private GenericHttpMessageConverter genericHttpMessageConverter;
    @Autowired
    AssessService  assessService;

    @Override
    public List<OrderGetVO> list(OrderGetBO orderGetBO) {
        try {
            if (!CollectionUtils.isEmpty(orderGetBO.getCreateTimeRange())) {
                long milliseconds = orderGetBO.getCreateTimeRange().get(0);
                long milliseconds1 = orderGetBO.getCreateTimeRange().get(1);

                Instant instant = Instant.ofEpochMilli(milliseconds);
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                Instant instant1 = Instant.ofEpochMilli(milliseconds1);
                LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault());

                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDate = localDateTime.format(formatter);
                String formattedDate1 = localDateTime1.format(formatter1);
                orderGetBO.setCreateTimeEnd(formattedDate1);
                orderGetBO.setCreateTimeStart(formattedDate);
            }
            List<OrderGetVO> list = orderMapper.getList(orderGetBO);
            //搜索登陆人的订单，该订单的陪玩
            PeiWanGetBO peiWanGetBO = new PeiWanGetBO();
            List<PeiWanGetVO> peiWanGetVOList = peiWanService.list(peiWanGetBO);
            Map<Integer, PeiWanGetVO> peiWanGetVOMap = new HashMap<>();
            peiWanGetVOList.forEach(peiWanGetVO -> peiWanGetVOMap.put(peiWanGetVO.getId(), peiWanGetVO));

            //收集评价
            AssessGetBO assessGetBO=new AssessGetBO();
            Object loginId = StpUtil.getLoginId();
            CustomerGetBO customerGetBO=new CustomerGetBO();
            customerGetBO.setAccount(String.valueOf(loginId));
            CustomerVO one = customerMapper.getOne(customerGetBO);
            assessGetBO.setCustomerId(one.getId());
            List<AssessGetVO> assessGetVOlist = assessService.getList(assessGetBO);
            Map<Integer, AssessGetVO> assessGetVOMap = new HashMap<>();
            assessGetVOlist.forEach(assessGetVO -> assessGetVOMap.put(assessGetVO.getOrderId(), assessGetVO));

            GameTypeBO gameTypeBO=new GameTypeBO();
            List<GameTypeVO> GameTypeVOlist = gameTypeService.getList(gameTypeBO);
            Map<Integer, GameTypeVO> GameTypeVOMap = new HashMap<>();
            GameTypeVOlist.forEach(gameTypeVO -> GameTypeVOMap.put(gameTypeVO.getId(), gameTypeVO));
            List<OrderGetVO> newList = new ArrayList<>();
            for (OrderGetVO orderGetVO : list) {
                OrderGetVO neworderGetVO = new OrderGetVO();
                BeanUtils.copyProperties(orderGetVO, neworderGetVO);
                String orderGoods = orderGetVO.getOrderGoods();
                Set<Integer> set = new HashSet<>();
                if (!StringUtils.isEmpty(orderGoods)) {
                    String[] split = orderGoods.split(",");

                    for (String s1 : split) {
                        set.add(Integer.valueOf(s1));
                    }
                }
                neworderGetVO.setGameType(GameTypeVOMap.get(orderGetVO.getOrderGameTypeId()));
                neworderGetVO.setPeiwan(peiWanGetVOMap.get(orderGetVO.getPeiwanId()));
                neworderGetVO.setAssess(assessGetVOMap.get(orderGetVO.getId()));

                newList.add(neworderGetVO);
            }
            return newList;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public OrderGetVO getone(OrderGetBO orderGetBO) {
        try {
            OrderGetVO orderGetVO = orderMapper.getOne(orderGetBO);
            GameTypeBO gameTypeBO = new GameTypeBO();
            gameTypeBO.setId(orderGetVO.getOrderGameTypeId());
            GameTypeVO one1 = gameTypeService.getOne(gameTypeBO);
            orderGetVO.setGameType(one1);
            PeiWanGetBO peiWanGetBO = new PeiWanGetBO();
            peiWanGetBO.setId(orderGetVO.getPeiwanId());
            PeiWanGetVO one = peiWanService.getOne(peiWanGetBO);
            orderGetVO.setPeiwan(one);
            return orderGetVO;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    @Transactional
    public RetStatus<Object> update(OrderUpdateBO orderUpdateBO) {
        RetStatus<Object> retStatus = new RetStatus<>();
        System.out.println(JSON.toJSONString(orderUpdateBO));

        if (orderUpdateBO.getId() == 0 && !StringUtils.isEmpty(orderUpdateBO.getOrderNo())) {
            OrderGetBO orderGetBO = new OrderGetBO();
            orderGetBO.setOrderNo(orderUpdateBO.getOrderNo());
            OrderGetVO one = orderMapper.getOne(orderGetBO);
            orderUpdateBO.setId(one.getId());

        }

        if (orderUpdateBO.getOrderStatus() == OrderStatusEnums.yiwancheng.getCode()) {
            Integer orderGameTypeId = orderUpdateBO.getOrderGameTypeId();
            GameTypeBO gameTypeBO = new GameTypeBO();
            gameTypeBO.setId(orderGameTypeId);
            GameTypeVO one = gameTypeService.getOne(gameTypeBO);
            GameTypeUpdateBO gameTypeUpdateBO = new GameTypeUpdateBO();
            gameTypeUpdateBO.setId(one.getId());
            gameTypeUpdateBO.setGameNumber(one.getGameNumber() + orderUpdateBO.getOrderNumber());
            gameTypeService.update(gameTypeUpdateBO);
            PeiWanGetBO peiWanGetBO = new PeiWanGetBO();
            peiWanGetBO.setId(orderUpdateBO.getPeiwanId());
            PeiWanGetVO one1 = peiWanService.getOne(peiWanGetBO);
            PeiWanUpdateBO peiWanUpdateBO = new PeiWanUpdateBO();
            peiWanUpdateBO.setId(one1.getId());
            peiWanUpdateBO.setPeiwanNumber(one1.getPeiwanNumber() + orderUpdateBO.getOrderNumber());
            peiWanService.update(peiWanUpdateBO);
        }
        Integer i = orderMapper.updateOrder(orderUpdateBO);
        if (!i.equals(1)) {
            retStatus.set("-1", "更新失败");
        }

        return retStatus;
    }

    @Override
    public Long getLong(OrderGetBO orderGetBO) {
        Long total = orderMapper.getLong(orderGetBO);
        return total;
    }

    /**
     * 添加订单，把订单添加到redis，如果有新的订单，前端提醒
     *
     * @param orderAddBO
     */
    @Override
    public RetStatus<Object> add(OrderAddBO orderAddBO) {
        RetStatus<Object> retStatus = new RetStatus<>();
        try {
            //看接单人跟订单中的陪玩是不是同一个
            Object loginId = StpUtil.getLoginId();
            String account = orderAddBO.getAccount();
            CustomerGetBO customerGetBO = new CustomerGetBO();
            customerGetBO.setAccount(account);
            CustomerVO one = customerMapper.getOne(customerGetBO);
            PeiWanGetBO peiWanGetBO= new PeiWanGetBO();
            peiWanGetBO.setId(orderAddBO.getPeiwanId());
            PeiWanGetVO peiWanGetVO= peiWanService.getOne(peiWanGetBO);
            if (peiWanGetVO.getIdCard().equals(one.getIdCard())) {
                retStatus.set("-1","不能接陪玩是自己的订单");
                return retStatus;
            }
            OrderPOJO orderPOJO = new OrderPOJO();
            long timestamp = System.currentTimeMillis();
            BeanUtils.copyProperties(orderAddBO, orderPOJO);
            orderPOJO.setOrderNo("dingdan" + timestamp + orderAddBO.getOrderGameTypeId());

            if (one != null) {
                orderPOJO.setOrderPayCustomerId(one.getId());
                orderPOJO.setOrderMobile(Long.valueOf(one.getPhone()));
                orderPOJO.setOrderPayName(one.getName());
            }
            orderPOJO.setOrderGameTypeId(orderAddBO.getOrderGameTypeId());
            orderPOJO.setOrderNumber(orderAddBO.getOrderNumber());
            orderPOJO.setOrderPrice(orderAddBO.getOrderPrice());
            orderPOJO.setOrderPayCustomerId(one.getId());
            orderPOJO.setCustomerId(one.getId());
            orderMapper.addOrder(orderPOJO);
        } catch (Exception e) {
            e.printStackTrace();
            retStatus.set("-1", "系统异常");
            return retStatus;
        }
        return retStatus;
    }
}
