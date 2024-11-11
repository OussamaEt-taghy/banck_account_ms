package oussama.it.customer_service.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import oussama.it.customer_service.Config.GlobalConfig;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {

    // la 1er solution
 @Value("${global.params.p1}")
    private int  p1;

    @Value("${global.params.p2}")
    private int p2;

    @Value("${customer.params.x}")
    private int x;

    @Value("${customer.params.y}")
    private int y;

    @GetMapping("/testConfig")
    public Map<String, Integer> testConfig() {
        return Map.of("p1", p1, "p2", p2, "x", x, "y", y);
    }

    // la 2eme solution c'est de creer un record qui contiet les variable global et d'anjecter ici
    @Autowired
    private GlobalConfig globalConfig;
    @GetMapping("testConfig-1")
    public GlobalConfig getGlobalConfig() {
        return globalConfig;
    }


}
