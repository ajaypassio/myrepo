package com.java8.test;
	/*import javax.jms.DeliveryMode;
	import javax.jms.JMSException;
	import javax.jms.Queue;
	import javax.jms.QueueConnection;
	import javax.jms.QueueReceiver;
	import javax.jms.QueueSender;
	import javax.jms.QueueSession;
	import javax.jms.Session;
	import javax.jms.TextMessage;

	import org.apache.log4j.Logger;

	import com.ibm.EAIQueue.constant.EAIConstant;
	import com.ibm.EAIQueue.exception.PropertiesFileException;
	import com.ibm.EAIQueue.property.manager.utility.PropertyManagerUtility;
	import com.ibm.mq.jms.JMSC;
	import com.ibm.mq.jms.MQQueueConnectionFactory;*/

public class EAIQueue {/*


		private static Logger logger = Logger.getLogger(JMSAgent.class.getClass());
		*//**
		* 
		* @param string
		* @return
		* @throws JMSException
		* @throws PropertiesFileException
		*//*

		public TextMessage fetchBillPlanDetailsResponse(String corelationId) throws JMSException, PropertiesFileException {

			logger.info("Enter method fetchOTPostpaidResponse with  CoRelationId is ::"+corelationId);
			TextMessage textMessage = null;
			long startTime = System.currentTimeMillis();
			QueueSession queueSession = null;
			QueueConnection queueConnection = null;
			QueueReceiver queueReceiver = null;
			QueueSender queueSender = null;

			String responseQueueHostName =PropertyManagerUtility.getValueFromBundle(EAIConstant.Response_Queue_Host_Name.trim(),EAIConstant.RESOURCE_BUNDLE_EAI).trim();
			String responseQueueChannel =PropertyManagerUtility.getValueFromBundle(EAIConstant.Response_Queue_Channel.trim(),EAIConstant.RESOURCE_BUNDLE_EAI).trim();
			String responseQueuePort =PropertyManagerUtility.getValueFromBundle(EAIConstant.Response_Queue_Port.trim(),EAIConstant.RESOURCE_BUNDLE_EAI).trim();
			String responseQueueManager =PropertyManagerUtility.getValueFromBundle(EAIConstant.Response_Queue_Manager.trim(),EAIConstant.RESOURCE_BUNDLE_EAI).trim();
			String responseQueueName =PropertyManagerUtility.getValueFromBundle(EAIConstant.Response_Queue_Name.trim(),EAIConstant.RESOURCE_BUNDLE_EAI).trim();
			String responseQueueTimeOut =PropertyManagerUtility.getValueFromBundle(EAIConstant.Response_Queue_TimeOut.trim(),EAIConstant.RESOURCE_BUNDLE_EAI).trim();

			
			String responseQueueHostName ="10.14.4.133";
			String responseQueueChannel ="QMEIGP1.MG.SVRCONN";
			String responseQueuePort ="8121";
			String responseQueueManager ="QMEIGP1";
			String responseQueueName ="MAGIC.CRM.SVC.RPO.01";
			String responseQueueTimeOut ="5000";	

			try{
				logger.info("Queue Details  for postOTPostpaidProvResponse with Host Name is : "+responseQueueHostName + " " +
						"Queue Channel is ::" +responseQueueChannel +"Queue Port is :" +responseQueuePort +
						"Queue Manager is :"+responseQueueManager + "Queue Name is ::" +responseQueueName);
				com.ibm.mq.jms.MQQueueConnectionFactory queueConnectionFactory = new com.ibm.mq.jms.MQQueueConnectionFactory();
				queueConnectionFactory.setHostName(responseQueueHostName);
				queueConnectionFactory.setChannel(responseQueueChannel);
				queueConnectionFactory.setPort(Integer.parseInt(responseQueuePort));
				queueConnectionFactory.setQueueManager(responseQueueManager);
				queueConnectionFactory.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP);
				queueConnection = queueConnectionFactory.createQueueConnection("mqm", "");
				queueConnection.start();
				logger.info("Connection created with EAI for Provisioning Response \n");
				queueSession = queueConnection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
				textMessage = queueSession.createTextMessage(corelationId);
				Queue queue = queueSession.createQueue(responseQueueName);
				textMessage.setJMSReplyTo(queue);
				textMessage.setJMSType("mcd://xmlns");
				textMessage.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
				String messageSelector = " JMSCorrelationID = '"+ corelationId + "'";
				queueReceiver = queueSession.createReceiver(queue,messageSelector);
				textMessage = (TextMessage)queueReceiver.receive
						(Long.parseLong(responseQueueTimeOut));
				queue = queueReceiver.getQueue();
				logger.debug("Provisioning Response Message received from EAI : "+textMessage);	

			}
			catch(JMSException e){
				logger.error("fetchOTPostpaidResponse :: JMSException is generated when fetching response . "+e.getMessage());
				throw new JMSException(e.getMessage());

			}
			catch (Exception e) {
				logger.error("fetchOTPostpaidResponse :: Exception is generated when fetching response . "+e.getMessage());
				throw new JMSException(e.getMessage());


			}
			finally{
				long endTime = System.currentTimeMillis();
				logger.info("fetchOTPostpaidResponse :: Time taken for calling fetching response from CRM is :: "+(endTime-startTime));
				try{
					if(queueSender !=null)
						queueSender.close();
					if(queueReceiver !=null)
						queueReceiver.close();
					if(queueSession !=null)
						queueSession.close();
					if(queueConnection !=null)
						queueConnection.close();
				}
				catch(JMSException e){
					logger.error("JMSException is generated when Releasing Resources inside fetching response Provisioning Service  "+e.getMessage());
					throw new JMSException("JMSException occured in close queue session");

				}
			}
			logger.info("Enter method fetchOTPostpaidResponse with  CoRelationId is ::" +corelationId);
			return textMessage;
		}

		public TextMessage fetchBillDateDetailsResponse(String string) throws JMSException, PropertiesFileException {
			logger.info("Enter method fetchOTPostpaidResponse with  CoRelationId is ::" +string);
			TextMessage textMessage = null;
			long startTime = System.currentTimeMillis();
			QueueSession queueSession = null;
			QueueConnection queueConnection = null;
			QueueReceiver queueReceiver = null;
			QueueSender queueSender = null;

			String responseQueueHostName =PropertyManagerUtility.getValueFromBundle(EAIConstant.Response_Queue_Host_Name.trim(),EAIConstant.RESOURCE_BUNDLE_EAI).trim();
			String responseQueueChannel =PropertyManagerUtility.getValueFromBundle(EAIConstant.Response_Queue_Channel.trim(),EAIConstant.RESOURCE_BUNDLE_EAI).trim();
			String responseQueuePort =PropertyManagerUtility.getValueFromBundle(EAIConstant.Response_Queue_Port.trim(),EAIConstant.RESOURCE_BUNDLE_EAI).trim();
			String responseQueueManager =PropertyManagerUtility.getValueFromBundle(EAIConstant.Response_Queue_Manager.trim(),EAIConstant.RESOURCE_BUNDLE_EAI).trim();
			String responseQueueName =PropertyManagerUtility.getValueFromBundle(EAIConstant.Response_Queue_Name.trim(),EAIConstant.RESOURCE_BUNDLE_EAI).trim();
			String responseQueueTimeOut =PropertyManagerUtility.getValueFromBundle(EAIConstant.Response_Queue_TimeOut.trim(),EAIConstant.RESOURCE_BUNDLE_EAI).trim();

			TND
					String responseQueueHostName ="10.14.111.104";
				String responseQueueChannel ="SYSTEM.DEF.SVRCONN";
				String responseQueuePort ="5422";
				String responseQueueManager ="QMEIGS7";
				String responseQueueName ="MAGIC.CRM.SVC.RPO.01";
				String responseQueueTimeOut ="100000";	
				   


			Production details
						String responseQueueHostName ="10.14.4.133";
				String responseQueueChannel ="QMEIGP1.MG.SVRCONN";
				String responseQueuePort ="8121";
				String responseQueueManager ="QMEIGP1";
				String responseQueueName ="MAGIC.CRM.SVC.RPO.01";
				String responseQueueTimeOut ="5000";	
						
			try{
				logger.info("Queue Details  for postOTPostpaidProvResponse with Host Name is : "+responseQueueHostName + " " +
						"Queue Channel is ::" +responseQueueChannel +"Queue Port is :" +responseQueuePort +
						"Queue Manager is :"+responseQueueManager + "Queue Name is ::" +responseQueueName);
				com.ibm.mq.jms.MQQueueConnectionFactory queueConnectionFactory = new com.ibm.mq.jms.MQQueueConnectionFactory();
				queueConnectionFactory.setHostName(responseQueueHostName);
				queueConnectionFactory.setChannel(responseQueueChannel);
				queueConnectionFactory.setPort(Integer.parseInt(responseQueuePort));
				queueConnectionFactory.setQueueManager(responseQueueManager);
				queueConnectionFactory.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP);
				queueConnection = queueConnectionFactory.createQueueConnection("mqm", "");
				queueConnection.start();
				logger.info("Connection created with EAI for Provisioning Response \n");
				queueSession = queueConnection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
				textMessage = queueSession.createTextMessage(string);
				Queue queue = queueSession.createQueue(responseQueueName);
				textMessage.setJMSReplyTo(queue);
				textMessage.setJMSType("mcd://xmlns");
				textMessage.setJMSDeliveryMode(DeliveryMode.PERSISTENT);

				String messageSelector = " JMSCorrelationID = '"+ string + "'";
				queueReceiver = queueSession.createReceiver(queue,messageSelector);

				textMessage = (TextMessage)queueReceiver.receive
						(Long.parseLong(responseQueueTimeOut));

				queue = queueReceiver.getQueue();
				logger.debug("Provisioning Response Message received from EAI : "+textMessage);	

			}
			catch(JMSException e){
				logger.error("fetchOTPostpaidResponse :: JMSException is generated when fetching response . "+e.getMessage());
				throw new JMSException(e.getMessage());

			}
			catch (Exception e) {
				logger.error("fetchOTPostpaidResponse :: Exception is generated when fetching response . "+e.getMessage());
				throw new JMSException(e.getMessage());


			}
			finally{
				long endTime = System.currentTimeMillis();
				logger.info("fetchOTPostpaidResponse :: Time taken for calling fetching response from CRM is :: "+(endTime-startTime));
				try{
					if(queueSender !=null)
						queueSender.close();
					if(queueReceiver !=null)
						queueReceiver.close();
					if(queueSession !=null)
						queueSession.close();
					if(queueConnection !=null)
						queueConnection.close();
				}
				catch(JMSException e){
					logger.error("JMSException is generated when Releasing Resources inside fetching response Provisioning Service  "+e.getMessage());
					throw new JMSException("JMSException occured in close queue session");

				}
			}
			logger.info("Enter method fetchOTPostpaidResponse with  CoRelationId is ::" +string);
			return textMessage;
		}
		*//**
		* Send request to EAI for Postpaid Plan PROCESSING 
		* @param reqXML
		* @return TextMessage
		* @throws CashBackCacheException 
		*//*
		public String putRequestInEaiQueue(String reqXML)throws JMSException{
			logger.info("" +
					" "+reqXML);
			TextMessage textMessage = null;
			long startTime = System.currentTimeMillis();
			QueueSession queueSession = null;
			QueueConnection queueConnection = null;
			QueueSender queueSender = null;
			String correlationId = null;

			String requestQueueHostName =PropertyManagerUtility.getValueFromBundle(EAIConstant.Request_Queue_Host_Name,EAIConstant.RESOURCE_BUNDLE_EAI).trim();
			String requestQueueChannel =PropertyManagerUtility.getValueFromBundle(EAIConstant.Request_QueueC_hannel,EAIConstant.RESOURCE_BUNDLE_EAI).trim();
			String requestQueuePort =PropertyManagerUtility.getValueFromBundle(EAIConstant.Request_Queue_Port,EAIConstant.RESOURCE_BUNDLE_EAI).trim();
			String requestQueueManager =PropertyManagerUtility.getValueFromBundle(EAIConstant.Request_Queue_Manager,EAIConstant.RESOURCE_BUNDLE_EAI).trim();
			String requestQueueName =PropertyManagerUtility.getValueFromBundle(EAIConstant.Request_Queue_Name,EAIConstant.RESOURCE_BUNDLE_EAI).trim();
			//String requestQueueTimeOut =PropertyManagerUtility.getValueFromBundle(EAIConstant.Request_Queue_TimeOut,EAIConstant.RESOURCE_BUNDLE_EAI).trim();
						String requestQueueHostName ="10.14.4.133";
				String requestQueueChannel ="QMEIGP1.MG.SVRCONN";
				String requestQueuePort ="8121";
				String requestQueueManager ="QMEIGP1";
				String requestQueueName ="MAGIC.CRM.SVC.RQI.01";
				String requestQueueTimeOut ="5000";			

			
			try{
				logger.info("Queue Details  for eaiPostpaidPlanRequest with Host Name is : "+requestQueueHostName+"" +
						"Queue Channel is ::" +requestQueueChannel +"Queue Port is :" +requestQueuePort +
						"Queue Manager is :"+requestQueueManager + "Queue Name is ::" +requestQueueName);
				MQQueueConnectionFactory queueConnectionFactory = new MQQueueConnectionFactory();
				queueConnectionFactory.setHostName(requestQueueHostName);
				queueConnectionFactory.setChannel(requestQueueChannel);
				queueConnectionFactory.setPort(Integer.parseInt(requestQueuePort));
				queueConnectionFactory.setQueueManager(requestQueueManager);
				queueConnectionFactory.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP);
				queueConnection = queueConnectionFactory.createQueueConnection("mqm", "");

				//queueConnection.start();
				logger.info("Connection created with EAI for OT POP Processing Request \n");
				queueSession = queueConnection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
				textMessage = queueSession.createTextMessage(reqXML);
				Queue queue = queueSession.createQueue(requestQueueName);
				textMessage.setJMSReplyTo(queue);
				textMessage.setJMSType("mcd://xmlns");
				textMessage.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
				queueSender = queueSession.createSender(queueSession.createQueue(requestQueueName));
				logger.debug("BEFORE Calling EAI  Service textMessage.getJMSMessageID() "+ textMessage.getJMSMessageID());
				queueSender.send(textMessage);
				correlationId = textMessage.getJMSMessageID();
				logger.debug("After Calling EAI Service textMessage.getJMSMessageID() "+ correlationId);
				System.out.print("Correlation id"+correlationId);
				if (correlationId == null) {
					throw new JMSException("MessageID id NULL");
				}

			}
			catch(JMSException e){
				logger.error("eaiPostpaidPlanRequest :: JMSException is generated when subscribing service.. "+e.getMessage());
				throw new JMSException(e.getMessage());

			}
			catch(Exception e){
				logger.error("eaiPostpaidPlanRequest :: Exception is generated when subscribing service.. "+e.getMessage());
				throw new JMSException(e.getMessage());


			}

			finally{
				long endTime = System.currentTimeMillis();
				logger.info("eaiPostpaidPlanRequest :: Time taken for calling provisioning service of EAI is :: "+(endTime-startTime));
				try{
					if(queueSender !=null)
						queueSender.close();
					if(queueSession !=null)
						queueSession.close();
					if(queueConnection !=null)
						queueConnection.close();
				}
				catch(JMSException e){
					logger.error("eaiPostpaidPlanRequest :: JMSException is generated when Releasing Resources inside Provisioning Service  "+e.getMessage());
					throw new JMSException("JMSException occured in close queue session");

				}
			}
			logger.info("Ended method eaiPostpaidPlanRequest with request XML is "+reqXML);

			return correlationId;
		}



	*/}



