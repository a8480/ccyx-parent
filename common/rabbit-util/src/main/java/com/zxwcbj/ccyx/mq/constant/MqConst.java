package com.zxwcbj.ccyx.mq.constant;

public class MqConst {
    /**
     * 消息补偿
     */
    public static final String MQ_KEY_PREFIX = "ccyx.mq:list";
    public static final int RETRY_COUNT = 3;

    /**
     * 商品上下架
     */
    public static final String EXCHANGE_GOODS_DIRECT = "ccyx.goods.direct";
    public static final String ROUTING_GOODS_UPPER = "ccyx.goods.upper";
    public static final String ROUTING_GOODS_LOWER = "ccyx.goods.lower";
    //队列
    public static final String QUEUE_GOODS_UPPER  = "ccyx.goods.upper";
    public static final String QUEUE_GOODS_LOWER  = "ccyx.goods.lower";

    /**
     * 团长上下线
     */
    public static final String EXCHANGE_LEADER_DIRECT = "ccyx.leader.direct";
    public static final String ROUTING_LEADER_UPPER = "ccyx.leader.upper";
    public static final String ROUTING_LEADER_LOWER = "ccyx.leader.lower";
    //队列
    public static final String QUEUE_LEADER_UPPER  = "ccyx.leader.upper";
    public static final String QUEUE_LEADER_LOWER  = "ccyx.leader.lower";

    //订单
    public static final String EXCHANGE_ORDER_DIRECT = "ccyx.order.direct";
    public static final String ROUTING_ROLLBACK_STOCK = "ccyx.rollback.stock";
    public static final String ROUTING_MINUS_STOCK = "ccyx.minus.stock";

    public static final String ROUTING_DELETE_CART = "ccyx.delete.cart";
    //解锁普通商品库存
    public static final String QUEUE_ROLLBACK_STOCK = "ccyx.rollback.stock";
    public static final String QUEUE_SECKILL_ROLLBACK_STOCK = "ccyx.seckill.rollback.stock";
    public static final String QUEUE_MINUS_STOCK = "ccyx.minus.stock";
    public static final String QUEUE_DELETE_CART = "ccyx.delete.cart";

    //支付
    public static final String EXCHANGE_PAY_DIRECT = "ccyx.pay.direct";
    public static final String ROUTING_PAY_SUCCESS = "ccyx.pay.success";
    public static final String QUEUE_ORDER_PAY  = "ccyx.order.pay";
    public static final String QUEUE_LEADER_BILL  = "ccyx.leader.bill";

    //取消订单
    public static final String EXCHANGE_CANCEL_ORDER_DIRECT = "ccyx.cancel.order.direct";
    public static final String ROUTING_CANCEL_ORDER = "ccyx.cancel.order";
    //延迟取消订单队列
    public static final String QUEUE_CANCEL_ORDER  = "ccyx.cancel.order";

    /**
     * 定时任务
     */
    public static final String EXCHANGE_DIRECT_TASK = "ccyx.exchange.direct.task";
    public static final String ROUTING_TASK_23 = "ccyx.task.23";
    //队列
    public static final String QUEUE_TASK_23  = "ccyx.queue.task.23";
}
