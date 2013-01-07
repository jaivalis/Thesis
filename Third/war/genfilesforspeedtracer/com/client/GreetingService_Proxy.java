package com.client;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class GreetingService_Proxy extends RemoteServiceProxy implements com.client.GreetingServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.client.GreetingService";
  private static final String SERIALIZATION_POLICY ="8E85B0C1F21FD3C7371B93B5AB0EBD22";
  private static final com.client.GreetingService_TypeSerializer SERIALIZER = new com.client.GreetingService_TypeSerializer();
  
  public GreetingService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "greet", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void getActiveSessionsForPastMins(int site, int containerSize, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GreetingService_Proxy", "getActiveSessionsForPastMins");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("I");
      streamWriter.writeString("I");
      streamWriter.writeInt(site);
      streamWriter.writeInt(containerSize);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getActiveSessionsForThePastXMins(int site, int mins, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GreetingService_Proxy", "getActiveSessionsForThePastXMins");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("I");
      streamWriter.writeString("I");
      streamWriter.writeInt(site);
      streamWriter.writeInt(mins);
      helper.finish(callback, ResponseReader.INT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getBrowserForPastDays(int site, int containerSize, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GreetingService_Proxy", "getBrowserForPastDays");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("I");
      streamWriter.writeString("I");
      streamWriter.writeInt(site);
      streamWriter.writeInt(containerSize);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getBytesForDateRange(int site, java.lang.String date, int daysForth, com.google.gwt.user.client.rpc.AsyncCallback asyncCallback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GreetingService_Proxy", "getBytesForDateRange");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("I");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("I");
      streamWriter.writeInt(site);
      streamWriter.writeString(date);
      streamWriter.writeInt(daysForth);
      helper.finish(asyncCallback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      asyncCallback.onFailure(ex);
    }
  }
  
  public void getOSForPastDays(int site, int containerSize, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GreetingService_Proxy", "getOSForPastDays");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("I");
      streamWriter.writeString("I");
      streamWriter.writeInt(site);
      streamWriter.writeInt(containerSize);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getTotalBytesForDateRange(int shop, java.lang.String dt, int daysForth, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GreetingService_Proxy", "getTotalBytesForDateRange");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("I");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("I");
      streamWriter.writeInt(shop);
      streamWriter.writeString(dt);
      streamWriter.writeInt(daysForth);
      helper.finish(callback, ResponseReader.LONG);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void getVisitorLocationsForDateRange(int site, java.lang.String date, int daysForth, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GreetingService_Proxy", "getVisitorLocationsForDateRange");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("I");
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString("I");
      streamWriter.writeInt(site);
      streamWriter.writeString(date);
      streamWriter.writeInt(daysForth);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  @Override
  public SerializationStreamWriter createStreamWriter() {
    ClientSerializationStreamWriter toReturn =
      (ClientSerializationStreamWriter) super.createStreamWriter();
    if (getRpcToken() != null) {
      toReturn.addFlags(ClientSerializationStreamWriter.FLAG_RPC_TOKEN_INCLUDED);
    }
    return toReturn;
  }
  @Override
  protected void checkRpcTokenType(RpcToken token) {
    if (!(token instanceof com.google.gwt.user.client.rpc.XsrfToken)) {
      throw new RpcTokenException("Invalid RpcToken type: expected 'com.google.gwt.user.client.rpc.XsrfToken' but got '" + token.getClass() + "'");
    }
  }
}
