package com.github.wheatphp.blog.prometheus.service.impl;

import com.github.wheatphp.blog.prometheus.bean.DimensionMap;
import com.github.wheatphp.blog.prometheus.bean.TagImpl;
import com.github.wheatphp.blog.prometheus.service.MonitorMetricService;
import io.micrometer.core.instrument.Tag;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class MonitorMetricServiceImpl implements MonitorMetricService {

    @Override
    public String getMetrics() {
        // 声明prometheus指标注册类
        PrometheusMeterRegistry prometheusRegistry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
        // 声明dimensionMap
        Map<String, String> dimensionMap;
        // dimensions that must include
        dimensionMap = DimensionMap.setDimensions(
                "3bdd9734-b34c-4194-9331-c543d0a9c013",
                "ecs-test-vm1",
                "serviceops",
                "cn-north-3",
                "cms");
        // dimensions that user defined
        List<Tag> dimensions = new LinkedList<>();
        for (Map.Entry<String, String> entry : dimensionMap.entrySet()) {
            Tag tag = new TagImpl(entry.getKey(), entry.getValue());
            dimensions.add(tag);
        }
        // 模拟数据
        Random random = new Random();
        double a = random.nextDouble() * 100;
        // 注册gauge类型指标
        // 参数：指标名，dimensions，需监控数据
        prometheusRegistry.gauge("test_cpu_user", dimensions, a);
//        prometheusRegistry.counter()
        // 注册第二个监控数据
        double b = random.nextDouble() * 100;
        prometheusRegistry.gauge("test_gpu_user", dimensions, b);

        // 注册第三个监控数据
        double c = random.nextDouble() * 100;
        prometheusRegistry.gauge("test_disk_user", dimensions, c);
        return prometheusRegistry.scrape();
    }
}
