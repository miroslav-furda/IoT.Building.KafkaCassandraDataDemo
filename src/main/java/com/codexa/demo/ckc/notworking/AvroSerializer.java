package com.codexa.demo.ckc.notworking;


import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;


/**
 * Created by peter on 3.8.2017.
 */

public class AvroSerializer<T extends SpecificRecordBase> implements Serializer<T> {

    private Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public void close() {
        // No-op
    }

    @Override
    public void configure(Map<String, ?> arg0, boolean arg1) {
        // No-op
    }

    @Override
    public byte[] serialize(String topic, T dataa) {
        try {
            byte[] result = null;

            if (dataa != null) {
                log.info("data=" + dataa);

                SensorDataEntityAvro data = (SensorDataEntityAvro) dataa;

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                BinaryEncoder binaryEncoder =
                        EncoderFactory.get().binaryEncoder(byteArrayOutputStream, null);

                DatumWriter<SensorDataEntityAvro> datumWriter = new GenericDatumWriter<>(data.getSchema());
                datumWriter.write(data, binaryEncoder);

                binaryEncoder.flush();
                byteArrayOutputStream.close();

                result = byteArrayOutputStream.toByteArray();
                log.info("serialized data=" +DatatypeConverter.printHexBinary(result));
            }
            return result;
        } catch (IOException ex) {
            throw new SerializationException(
                    "Can't serialize data='" + dataa + "' for topic='" + topic + "'", ex);
        }
    }
}