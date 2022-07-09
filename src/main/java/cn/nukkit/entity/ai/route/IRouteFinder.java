package cn.nukkit.entity.ai.route;

import cn.nukkit.api.PowerNukkitXOnly;
import cn.nukkit.api.Since;
import cn.nukkit.math.Vector3;

import java.util.ArrayList;

/**
 * 寻路器接口
 */
@PowerNukkitXOnly
@Since("1.6.0.0-PNX")
public interface IRouteFinder {
    /**
     * @return boolean
     * 是否正在寻路
     */
    boolean isSearching();

    /**
     * @return boolean
     * 是否完成寻路（找到有效路径）
     */
    boolean isFinished();

    /**
     * @return boolean
     * 寻路是否被中断了
     */
    boolean isInterrupt();

    /**
     * 是否可到达终点
     * 在调用此方法前，你应该首先尝试寻路，否则此方法始将终返回true
     */
    boolean isReachable();

    /**
     * 尝试寻路
     * @return boolean
     * 是否成功找到路径
     */
    boolean search();

    /**
     * 获取起始点
     */
    Vector3 getStart();

    /**
     * 获取终点
     */
    Vector3 getTarget();

    /**
     * 获取寻路结果
     */
    ArrayList<Node> getRoute();
}