package org.example.warehousemanagersystem.service.user.bo;

import lombok.Getter;
import lombok.Setter;
import org.example.warehousemanagersystem.service.user.pojo.UserPOJO;
import org.springframework.stereotype.Service;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-28
 * @Description:
 * @Version: 1.0
 */

@Setter
@Getter
public class UserAddBO extends UserPOJO {

   private String img;
}
