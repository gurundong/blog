package com.github.wheatphp.blog.prometheus;

import com.github.wheatphp.blog.prometheus.service.impl.MonitorMetricServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MetricsController {
    @Autowired
    MonitorMetricServiceImpl monitorMetricService;
    @RequestMapping("/metrics")
    public void metrics(HttpServletResponse response) throws IOException {
        String metrics = monitorMetricService.getMetrics();
        System.out.println(metrics);
        response.getWriter().write(metrics);

    }

}
