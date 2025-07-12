package resources.jmeter;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

import java.io.FileOutputStream;

public class HomePagePerformance {
    public static void main(String[] args) throws Exception {
        // Initialize JMeter environment
        String jmeterHomePath = "/usr/local/bin/apache-jmeter/"; // Set your JMeter home path
        JMeterUtils.setJMeterHome(jmeterHomePath);
        JMeterUtils.loadJMeterProperties(jmeterHomePath + "bin/jmeter.properties");
        JMeterUtils.initLocale();

        // Create JMeter engine
        StandardJMeterEngine engine = new StandardJMeterEngine();

        // Create Test Plan
        TestPlan testPlan = new TestPlan("Sample Load Test");

        // Create Loop Controller
        LoopController loopController = new LoopController();
        loopController.setLoops(10); // Number of iterations
        loopController.setFirst(true);
        loopController.initialize();

        // Create Thread Group
        ThreadGroup threadGroup = new ThreadGroup();
        threadGroup.setName("ThreadGroup");
        threadGroup.setNumThreads(50); // Number of users
        threadGroup.setRampUp(10); // Ramp-up period
        threadGroup.setSamplerController(loopController);

        // Create HTTPSampler (HTTP GET request)
        HTTPSamplerProxy httpSampler = new HTTPSamplerProxy();
        httpSampler.setDomain("automationintesting.online");
        httpSampler.setPort(443);
        httpSampler.setProtocol("https");
        httpSampler.setPath("/");
        httpSampler.setMethod("GET");
        httpSampler.setName("Open Homepage");
        httpSampler.setProperty(HTTPSamplerProxy.TEST_CLASS, HTTPSamplerProxy.class.getName());
        httpSampler.setProperty(HTTPSamplerProxy.GUI_CLASS, "org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui");

        // Build Test Plan tree
        HashTree testPlanTree = new HashTree();
        HashTree threadGroupHashTree = new HashTree();

        threadGroupHashTree.add(httpSampler);
        testPlanTree.add(testPlan);
        testPlanTree.add(threadGroup, threadGroupHashTree);

        // Add summariser
        Summariser summariser = new Summariser("Summary");
        ResultCollector resultCollector = new ResultCollector(summariser);
        resultCollector.setFilename("results.jtl");
        testPlanTree.add(testPlanTree.getArray()[0], resultCollector);

        // Configure and run
        engine.configure(testPlanTree);
        engine.run();
        engine.exit();

        // Save the test plan to a file (optional)
        try (FileOutputStream fos = new FileOutputStream("/usr/local/bin/apache-jmeter/bin/templates/testplan.jmx")) {
            SaveService.saveTree(testPlanTree, fos);
        }

        System.out.println("Test execution completed. Results saved to results.jtl");
    }
}
