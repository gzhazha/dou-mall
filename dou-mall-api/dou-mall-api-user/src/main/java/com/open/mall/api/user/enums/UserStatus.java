package com.open.mall.api.user.enums;

import com.open.mall.common.base.enums.ErrorEnum;
import com.open.mall.common.base.exception.MallBaseException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * UserStatus
 *
 * @author zhoug
 * @date 2025/4/29 16:13
 */

@AllArgsConstructor
@Getter
public enum UserStatus {


    /**
     * 0: 初始化/刚注册 - 用户刚刚创建，可能需要完成验证步骤，权限受限（例如，仅能获取临时Token进行验证操作）。
     */
    INITIALIZED(0, "初始化/刚注册"),

    /**
     * 1: 正常/活跃 - 用户账户验证通过，可以正常使用所有已授权的功能。
     */
    ACTIVE(1, "正常/活跃"),

    /**
     * 2: 待验证 - 用户已注册，但需要完成某个验证步骤（如邮箱验证、手机验证、人工审核）。
     */
    PENDING_VERIFICATION(2, "待验证"),

    /**
     * 3: 已禁用/暂停 - 管理员主动禁用该账户，用户无法登录或执行任何操作。
     */
    DISABLED(3, "已禁用/暂停"),

    /**
     * 4: 已注销/软删除 - 用户主动请求注销账户或系统进行了软删除，通常无法登录，数据可能被标记待清理。
     */
    DEACTIVATED(4, "已注销/软删除");

    /**
     * 存储在数据库中的状态码 (int 类型)。
     */
    private final int status;

    /**
     * 状态的描述信息。
     */
    private final String description;

    // --- 静态查找方法 ---

    // 提前构建 status 到 Enum 的映射，提高查找效率
    private static final Map<Integer, UserStatus> STATUS_MAP =
            Arrays.stream(values())
                    .collect(Collectors.toMap(UserStatus::getStatus, Function.identity()));

    /**
     * 根据整数状态码查找对应的 UserStatus 枚举实例。
     *
     * @param status 数据库中存储的状态码 (int)
     * @return 对应 UserStatus 的 Optional 包装，如果找不到则返回 Optional.empty()
     */
    public static Optional<UserStatus> findByStatus(Integer status) {
        return Optional.ofNullable(STATUS_MAP.get(status));
    }

    /**
     * 根据整数状态码获取对应的 UserStatus 枚举实例。
     * 如果找不到对应的状态码，将抛出 IllegalArgumentException。
     *
     * @param status 数据库中存储的状态码 (int)
     * @return 对应的 UserStatus 枚举实例
     * @throws IllegalArgumentException 如果传入的状态码无效
     */
    public static UserStatus fromStatus(Integer status) {
        return findByStatus(status)
                .orElseThrow(() -> new MallBaseException(ErrorEnum.SYSTEM_ERROR,"未知的用户状态"+status));
    }
}
