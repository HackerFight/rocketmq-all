package org.apache.rocketmq.client.consumer.rebalance.test;

import org.apache.rocketmq.client.consumer.AllocateMessageQueueStrategy;
import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragely;
import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragelyByCircle;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.ArrayList;
import java.util.List;

public class AllocateMessageQueueAveragelyTest {

    public static void main(String[] args) {


        AllocateMessageQueueStrategy avg = new AllocateMessageQueueAveragelyByCircle();

        String consumerGroup = "qiuguanGroup";
        String currentId = "2";

        List<String> allIds = new ArrayList<>();
        allIds.add("1");
        allIds.add("2");
        allIds.add("3");

        List<MessageQueue> mqList = new ArrayList<>();
        MessageQueue m1 = new MessageQueue();
        m1.setBrokerName("broker-a");
        m1.setTopic("test-topic");
        m1.setQueueId(0);
        mqList.add(m1);

        MessageQueue m2 = new MessageQueue();
        m2.setBrokerName("broker-a");
        m2.setTopic("test-topic");
        m2.setQueueId(1);
        mqList.add(m2);

        MessageQueue m3 = new MessageQueue();
        m3.setBrokerName("broker-a");
        m3.setTopic("test-topic");
        m3.setQueueId(2);
        mqList.add(m3);


        MessageQueue m4 = new MessageQueue();
        m4.setBrokerName("broker-a");
        m4.setTopic("test-topic");
        m4.setQueueId(3);
        mqList.add(m4);


        List<MessageQueue> allocate = avg.allocate(consumerGroup, currentId, mqList, allIds);

        for (MessageQueue messageQueue : allocate) {
            System.out.println("---->  " + messageQueue);
        }

    }
}
