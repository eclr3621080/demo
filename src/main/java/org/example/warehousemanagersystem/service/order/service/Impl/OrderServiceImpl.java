package org.example.warehousemanagersystem.service.order.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.customer.bo.CustomerGetBO;
import org.example.warehousemanagersystem.service.customer.mapper.CustomerMapper;
import org.example.warehousemanagersystem.service.customer.vo.CustomerVO;
import org.example.warehousemanagersystem.service.goods.bo.GoodsGetBO;
import org.example.warehousemanagersystem.service.goods.mapper.GoodsMapper;
import org.example.warehousemanagersystem.service.order.bo.OrderAddBO;
import org.example.warehousemanagersystem.service.order.bo.OrderGetBO;
import org.example.warehousemanagersystem.service.order.bo.OrderUpdateBO;
import org.example.warehousemanagersystem.service.order.mapper.OrderMapper;
import org.example.warehousemanagersystem.service.order.pojo.OrderPOJO;
import org.example.warehousemanagersystem.service.order.service.OrderService;
import org.example.warehousemanagersystem.service.order.vo.OrderGetVO;
import org.example.warehousemanagersystem.service.user.pojo.UserPOJO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    SimpMessagingTemplate messagingTemplate;
    @Override
    public List<OrderGetVO> list(OrderGetBO orderGetBO) {
        try {
            if (!CollectionUtils.isEmpty(orderGetBO.getCreateTimeRange())){
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
            List<OrderGetVO>  list   =orderMapper.getList(orderGetBO);
            List<OrderGetVO>   newList=new ArrayList<>();

            for (OrderGetVO orderGetVO:list){
                OrderGetVO  neworderGetVO = new OrderGetVO();
                BeanUtils.copyProperties(orderGetVO,neworderGetVO);
                GoodsGetBO goodsGetBO=new  GoodsGetBO();
                String orderGoods = orderGetVO.getOrderGoods();
                String[] split = orderGoods.split(",");
                Set<Integer> set = new HashSet<>();
                for (String s1:split){
                    set.add(Integer.valueOf(s1));
                }

                goodsGetBO.setIds(set);

                neworderGetVO.setGoods(  goodsMapper.listGoods(goodsGetBO));
                newList.add(neworderGetVO);
            }
            return newList;
        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public OrderGetVO getone(OrderGetBO orderGetBO) {
        try {
            OrderGetVO  orderGetVO   =orderMapper.getOne(orderGetBO);
            GoodsGetBO goodsGetBO=new  GoodsGetBO();
            String orderGoods = orderGetVO.getOrderGoods();
            String[] split = orderGoods.split(",");
            Set<Integer> set = new HashSet<>();
            for (String s1:split){
                set.add(Integer.valueOf(s1));
            }

            goodsGetBO.setIds(set);

            orderGetVO.setGoods(  goodsMapper.listGoods(goodsGetBO));

            return orderGetVO;
        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public RetStatus<Object> update(OrderUpdateBO orderUpdateBO) {
        RetStatus<Object> retStatus = new RetStatus<>();
        System.out.println(JSON.toJSONString(orderUpdateBO));

            if (orderUpdateBO.getId()==0 && !StringUtils.isEmpty(orderUpdateBO.getOrderNo())){
                OrderGetBO orderGetBO=new  OrderGetBO();
                orderGetBO.setOrderNo(orderUpdateBO.getOrderNo());
                OrderGetVO one = orderMapper.getOne(orderGetBO);
                orderUpdateBO.setId(one.getId());
            }
          Integer i=   orderMapper.updateOrder(orderUpdateBO);
            if (!i.equals(1) ) {
                retStatus.set("-1", "更新失败");
            }

        return retStatus;
    }

    @Override
    public Long getLong(OrderGetBO orderGetBO) {
       Long total= orderMapper.getLong(orderGetBO);
       return total;
    }

    /**
     * 添加订单，把订单添加到redis，如果有新的订单，前端提醒
     * @param orderAddBO
     */
    @Override
    @Transactional
    public void add(OrderAddBO orderAddBO) {

        OrderPOJO orderPOJO = new OrderPOJO();
        long timestamp = System.currentTimeMillis();

        BeanUtils.copyProperties(orderAddBO,orderPOJO);
        orderPOJO.setOrderNo("dingdan"+timestamp+orderAddBO.getOrderGoods());
        String account = orderAddBO.getAccount();
        CustomerGetBO customerGetBO=new CustomerGetBO();
        customerGetBO.setAccount(account);
        CustomerVO one = customerMapper.getOne(customerGetBO);
        orderPOJO.setOrderMobile(Long.valueOf(one.getPhone()));
        orderMapper.addOrder(orderPOJO);

    }
}
