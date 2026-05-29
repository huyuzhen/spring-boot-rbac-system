# Spring Boot RBAC Permission Management System

完整的基于 SpringBoot 2.x 的后台权限管理系统，集成 MyBatis、MySQL、Druid、Sa-Token。

## 🌟 Features

- ✅ **RBAC 权限模型** - 基于角色的访问控制
- ✅ **用户管理** - 用户增删改查、账号启用禁用
- ✅ **角色管理** - 角色增删改查、权限分配
- ✅ **权限管理** - 权限维护、权限树形结构
- ✅ **菜单管理** - 菜单维护、菜单路由配置
- ✅ **部门管理** - 部门维护、部门树形结构
- ✅ **Sa-Token 认证** - 轻量级认证授权框架
- ✅ **Druid 数据库连接池** - 性能监控、SQL防注入
- ✅ **AOP 权限校验** - 基于注解的权限校验
- ✅ **操作日志** - 记录用户操作日志
- ✅ **全局异常处理** - 统一响应格式
- ✅ **Swagger/Knife4j 文档** - API 文档自动生成

## 🛠️ 技术栈

| 技术 | 版本 | 说明 |
|------|------|------|
| Spring Boot | 2.7.14 | 基础框架 |
| MyBatis | 2.2.2 | ORM 框架 |
| MyBatis Plus | 3.5.3 | MyBatis 增强工具 |
| MySQL | 8.0.33 | 数据库 |
| Druid | 1.2.16 | 数据库连接池 |
| Sa-Token | 1.34.0 | 认证授权 |
| Redis | - | 缓存存储 |
| Lombok | 1.18.30 | 代码生成 |
| Hutool | 5.8.21 | 工具库 |
| Knife4j | 3.0.3 | API 文档 |

## 📦 Project Structure

```
spring-boot-rbac-system/
├── src/main/java/com/example/rbac/
│   ├── RbacApplication.java              # 启动类
│   ├── config/                            # 配置���
│   │   ├── SwaggerConfig.java             # Swagger 配置
│   │   ├── DruidConfig.java               # Druid 连接池配置
│   │   ├── SaTokenConfig.java             # Sa-Token 配置
│   │   ├── WebConfig.java                 # Web 配置
│   │   └── RedisConfig.java               # Redis 配置
│   ├── controller/                        # 控制层
│   │   ├── AuthController.java            # 认证控制器
│   │   ├── UserController.java            # 用户控制器
│   │   ├── RoleController.java            # 角色控制器
│   │   ├── PermissionController.java      # 权限控制器
│   │   ├── MenuController.java            # 菜单控制器
│   │   ├── DepartmentController.java      # 部门控制器
│   │   └── LogController.java             # 日志控制器
│   ├── service/                           # 业务层
│   │   ├── AuthService.java               # 认证业务
│   │   ├── UserService.java               # 用户业务
│   │   ├── RoleService.java               # 角色业务
│   │   ├── PermissionService.java         # 权限业务
│   │   ├── MenuService.java               # 菜单业务
│   │   ├── DepartmentService.java         # 部门业务
│   │   └── LogService.java                # 日志业务
│   ├── mapper/                            # 数据访问层
│   │   ├── UserMapper.java
│   │   ├── RoleMapper.java
│   │   ├── PermissionMapper.java
│   │   ├── MenuMapper.java
│   │   ├── DepartmentMapper.java
│   │   ├── RolePermissionMapper.java
│   │   ├── UserRoleMapper.java
│   │   └── LogMapper.java
│   ├── entity/                            # 实体类
│   │   ├── User.java
│   │   ├── Role.java
│   │   ├── Permission.java
│   │   ├── Menu.java
│   │   ├── Department.java
│   │   ├── RolePermission.java
│   │   ├── UserRole.java
│   │   └── OperationLog.java
│   ├── dto/                               # 数据传输对象
│   │   ├── LoginRequest.java
│   │   ├── UserDTO.java
│   │   ├── RoleDTO.java
│   │   ├── PermissionDTO.java
│   │   └── MenuDTO.java
│   ├── vo/                                # 视图对象
│   │   ├── UserVO.java
│   │   ├── RoleVO.java
│   │   └── LoginVO.java
│   ├── util/                              # 工具类
│   │   ├── ResponseUtil.java              # 响应统一格式
│   │   ├── ResultCode.java                # 响应码
│   │   ├── TreeUtil.java                  # 树形结构工具
│   │   ├── MD5Util.java                   # MD5 加密
│   │   ├── JwtUtil.java                   # JWT 工具
│   │   └── PageUtil.java                  # 分页工具
│   ├── exception/                         # 异常处理
│   │   ├── GlobalExceptionHandler.java    # 全局异常处理器
│   │   ├── BusinessException.java         # 业务异常
│   │   └── UnauthorizedException.java     # 未授权异常
│   ├── interceptor/                       # 拦截器
│   │   └── AuthInterceptor.java           # 认证拦截器
│   └── aop/                               # AOP
│       ├── PermissionCheckAspect.java     # 权限检查切面
│       └── OperationLogAspect.java        # 操作日志切面
├── src/main/resources/
│   ├── application.yml                    # 配置文件
│   ├── application-dev.yml                # 开发配置
│   ├── application-prod.yml               # 生产配置
│   ├── db/
│   │   └── schema.sql                     # 数据库初始化脚本
│   └── mapper/                            # MyBatis 映射文件
│       ├── UserMapper.xml
│       ├── RoleMapper.xml
│       ├── PermissionMapper.xml
│       └── ...
└── pom.xml
```

## 🚀 Quick Start

### 1. 环境要求

- JDK 1.8+
- MySQL 5.7+
- Redis 5.0+
- Maven 3.6+

### 2. 数据库初始化

```bash
# 创建数据库
CREATE DATABASE rbac_system DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

# 导入初始化脚本
mysql -u root -p rbac_system < src/main/resources/db/schema.sql
```

### 3. 配置文件

修改 `application.yml` 中的数据库和 Redis 连接信息：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/rbac_system?useUnicode=true&characterEncoding=utf-8
    username: root
    password: 123456
  redis:
    host: localhost
    port: 6379
    password: ""
```

### 4. 启动应用

```bash
mvn clean install
mvn spring-boot:run
```

### 5. 访问接口

- API 文档：http://localhost:8080/doc.html
- Druid 监控：http://localhost:8080/druid/index.html
- 默认账号：admin / 123456

## 📖 API 接口文档

### 1. 登录接口

```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "123456"
}

响应:
{
  "code": 200,
  "message": "Login successful",
  "data": {
    "token": "xxx",
    "userId": 1,
    "username": "admin",
    "realName": "Administrator"
  },
  "timestamp": 1234567890
}
```

### 2. 用户管理

```http
# 获取用户列表
GET /api/users?pageNo=1&pageSize=10

# 获取用户详情
GET /api/users/{id}

# 新增用户
POST /api/users
Content-Type: application/json

{
  "username": "user1",
  "password": "123456",
  "realName": "User One",
  "email": "user1@example.com",
  "deptId": 1
}

# 编辑用户
PUT /api/users/{id}

# 删除用户
DELETE /api/users/{id}

# 启用/禁用账户
POST /api/users/{id}/status?status={1|2}
```

### 3. 角色管理

```http
# 获取角色列表
GET /api/roles?pageNo=1&pageSize=10

# 新增角色
POST /api/roles

# 分配权限
POST /api/roles/{id}/permissions
Content-Type: application/json

{
  "permissionIds": [1, 2, 3]
}

# 获取角色的权限
GET /api/roles/{id}/permissions
```

### 4. 权限管理

```http
# 获取权限列表
GET /api/permissions

# 获取权限树
GET /api/permissions/tree

# 新增权限
POST /api/permissions
```

### 5. 菜单管理

```http
# 获取菜单树
GET /api/menus/tree

# 新增菜单
POST /api/menus

# 编辑菜单
PUT /api/menus/{id}

# 删除菜单
DELETE /api/menus/{id}
```

## 🔐 权限校验方式

### 方式 1：注解方式

```java
@RequiresPermissions("user:add")
@PostMapping("/users")
public ResponseUtil<?> addUser(@RequestBody UserDTO userDTO) {
    return userService.addUser(userDTO);
}
```

### 方式 2：代码方式

```java
public void someMethod() {
    // 检查是否有权限
    StpUtil.checkPermission("user:edit");
    // 业务逻辑
}
```

### 方式 3：角色检查

```java
@RequiresRoles("admin")
@GetMapping("/admin/data")
public ResponseUtil<?> getAdminData() {
    return ResponseUtil.success();
}
```

## 📝 常见问题

### Q1: 如何修改默认密码？

默认管理员账号：`admin / 123456`

密码存储在数据库中，采用 MD5 加密。可以通过修改用户信息接口更改密码。

### Q2: 如何扩展用户字段？

修改 `User.java` 实体类和 `sys_user` 表结构，同时更新对应的 Mapper 和 Service。

### Q3: 如何集成其他认证方式？

Sa-Token 支持多种认证方式，详见官方文档：https://sa-token.dev33.cn/

### Q4: 如何自定义权限校验逻辑？

修改 `PermissionCheckAspect.java` 中的权限校验逻辑，或通过 Sa-Token 的扩展接口。

## 📚 相关链接

- [Spring Boot 官方文档](https://spring.io/projects/spring-boot)
- [MyBatis 官方文档](https://mybatis.org/mybatis-3/)
- [Sa-Token 官方文档](https://sa-token.dev33.cn/)
- [Druid 官方文档](https://github.com/alibaba/druid)

## 📄 License

MIT

## 👨‍💻 Author

huyuzhen
