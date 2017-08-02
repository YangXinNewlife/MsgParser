package yangxin;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.flink.streaming.util.serialization.SimpleStringSchema;
import scala.Tuple3;

import java.util.Map;
import java.util.Properties;

/**
 * Created by ryan on 17-8-1.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("Start Message Parser");
        String kafkaTopic = "MsgParser";

        // Flink Stream Execute Environment
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(10);

        // Kafka Properties
        Properties props = new Properties();
        props.put("bootstrap","192.168.1.81:6667");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // set FlinkKafkaConsumer
        DataStream<String> messageStream =  env.addSource(new FlinkKafkaConsumer010<String>(kafkaTopic, new SimpleStringSchema(), props));

        //AdapterPaser adapterParser = new AdapterPaser(messageStream);


    }
}
