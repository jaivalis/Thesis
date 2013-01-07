package com.client;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SerializableContainer_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.client.SerializableContainer instance) throws SerializationException {
    instance.container = (java.util.TreeMap) streamReader.readObject();
    
  }
  
  public static com.client.SerializableContainer instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.client.SerializableContainer();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.client.SerializableContainer instance) throws SerializationException {
    streamWriter.writeObject(instance.container);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.client.SerializableContainer_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.client.SerializableContainer_FieldSerializer.deserialize(reader, (com.client.SerializableContainer)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.client.SerializableContainer_FieldSerializer.serialize(writer, (com.client.SerializableContainer)object);
  }
  
}
