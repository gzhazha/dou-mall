package com.open.mall.cart.domain.bo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * CartDetailsBo
 *
 * @author zhoug
 * @date 2025/6/24 15:40
 */


@Data
public class CartDetailsBo {
    /**
     * 购物车ID
     */
    private Long cartId;

    /**
     * 用户ID (FK users.id)，登录用户购物车
     */
    private Long userId;

    /**
     * 访客ID (UUID或临时标识)，访客购物车
     */
    private String guestId;

    /**
     * 购物车项表
     */
    List<CartItemBo> itemList;

    @Data
    public static class CartItemBo{

        /**
         * 主键 ID
         */
        private Long id;

        /**
         * 商品 SPU ID
         */
        private Long productId;

        /**
         * 商品 SKU ID
         */
        private Long skuId;

        /**
         * 商品数量
         */
        private Integer quantity;

        /**
         * 是否选中
         */
        private Integer selected;

        /**
         * 加入时的价格快照
         */
        private BigDecimal priceSnapshot;

        /**
         * SKU 名称快照（如颜色+尺码）
         */
        private String skuName;

        /**
         * 商品图片快照
         */
        private String productImage;

    }
}
