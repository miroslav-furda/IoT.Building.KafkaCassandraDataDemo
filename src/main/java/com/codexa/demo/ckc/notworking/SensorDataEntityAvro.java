/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.codexa.demo.ckc.notworking;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class SensorDataEntityAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8207402597840627029L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SensorDataEntityAvro\",\"namespace\":\"com.codexa.demo.ckc.avro\",\"fields\":[{\"name\":\"device_id\",\"type\":\"string\"},{\"name\":\"timestamp\",\"type\":\"string\"},{\"name\":\"type\",\"type\":[\"string\",\"null\"]},{\"name\":\"value\",\"type\":[\"string\",\"null\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<SensorDataEntityAvro> ENCODER =
      new BinaryMessageEncoder<SensorDataEntityAvro>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<SensorDataEntityAvro> DECODER =
      new BinaryMessageDecoder<SensorDataEntityAvro>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<SensorDataEntityAvro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<SensorDataEntityAvro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<SensorDataEntityAvro>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this SensorDataEntityAvro to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a SensorDataEntityAvro from a ByteBuffer. */
  public static SensorDataEntityAvro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public CharSequence device_id;
  @Deprecated public CharSequence timestamp;
  @Deprecated public CharSequence type;
  @Deprecated public CharSequence value;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public SensorDataEntityAvro() {}

  /**
   * All-args constructor.
   * @param device_id The new value for device_id
   * @param timestamp The new value for timestamp
   * @param type The new value for type
   * @param value The new value for value
   */
  public SensorDataEntityAvro(CharSequence device_id, CharSequence timestamp, CharSequence type, CharSequence value) {
    this.device_id = device_id;
    this.timestamp = timestamp;
    this.type = type;
    this.value = value;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return device_id;
    case 1: return timestamp;
    case 2: return type;
    case 3: return value;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: device_id = (CharSequence)value$; break;
    case 1: timestamp = (CharSequence)value$; break;
    case 2: type = (CharSequence)value$; break;
    case 3: value = (CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'device_id' field.
   * @return The value of the 'device_id' field.
   */
  public CharSequence getDeviceId() {
    return device_id;
  }

  /**
   * Sets the value of the 'device_id' field.
   * @param value the value to set.
   */
  public void setDeviceId(CharSequence value) {
    this.device_id = value;
  }

  /**
   * Gets the value of the 'timestamp' field.
   * @return The value of the 'timestamp' field.
   */
  public CharSequence getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the value of the 'timestamp' field.
   * @param value the value to set.
   */
  public void setTimestamp(CharSequence value) {
    this.timestamp = value;
  }

  /**
   * Gets the value of the 'type' field.
   * @return The value of the 'type' field.
   */
  public CharSequence getType() {
    return type;
  }

  /**
   * Sets the value of the 'type' field.
   * @param value the value to set.
   */
  public void setType(CharSequence value) {
    this.type = value;
  }

  /**
   * Gets the value of the 'value' field.
   * @return The value of the 'value' field.
   */
  public CharSequence getValue() {
    return value;
  }

  /**
   * Sets the value of the 'value' field.
   * @param value the value to set.
   */
  public void setValue(CharSequence value) {
    this.value = value;
  }

  /**
   * Creates a new SensorDataEntityAvro RecordBuilder.
   * @return A new SensorDataEntityAvro RecordBuilder
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Creates a new SensorDataEntityAvro RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new SensorDataEntityAvro RecordBuilder
   */
  public static Builder newBuilder(Builder other) {
    return new Builder(other);
  }

  /**
   * Creates a new SensorDataEntityAvro RecordBuilder by copying an existing SensorDataEntityAvro instance.
   * @param other The existing instance to copy.
   * @return A new SensorDataEntityAvro RecordBuilder
   */
  public static Builder newBuilder(SensorDataEntityAvro other) {
    return new Builder(other);
  }

  /**
   * RecordBuilder for SensorDataEntityAvro instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SensorDataEntityAvro>
    implements org.apache.avro.data.RecordBuilder<SensorDataEntityAvro> {

    private CharSequence device_id;
    private CharSequence timestamp;
    private CharSequence type;
    private CharSequence value;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.device_id)) {
        this.device_id = data().deepCopy(fields()[0].schema(), other.device_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[1].schema(), other.timestamp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.type)) {
        this.type = data().deepCopy(fields()[2].schema(), other.type);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.value)) {
        this.value = data().deepCopy(fields()[3].schema(), other.value);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing SensorDataEntityAvro instance
     * @param other The existing instance to copy.
     */
    private Builder(SensorDataEntityAvro other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.device_id)) {
        this.device_id = data().deepCopy(fields()[0].schema(), other.device_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[1].schema(), other.timestamp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.type)) {
        this.type = data().deepCopy(fields()[2].schema(), other.type);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.value)) {
        this.value = data().deepCopy(fields()[3].schema(), other.value);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'device_id' field.
      * @return The value.
      */
    public CharSequence getDeviceId() {
      return device_id;
    }

    /**
      * Sets the value of the 'device_id' field.
      * @param value The value of 'device_id'.
      * @return This builder.
      */
    public Builder setDeviceId(CharSequence value) {
      validate(fields()[0], value);
      this.device_id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'device_id' field has been set.
      * @return True if the 'device_id' field has been set, false otherwise.
      */
    public boolean hasDeviceId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'device_id' field.
      * @return This builder.
      */
    public Builder clearDeviceId() {
      device_id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'timestamp' field.
      * @return The value.
      */
    public CharSequence getTimestamp() {
      return timestamp;
    }

    /**
      * Sets the value of the 'timestamp' field.
      * @param value The value of 'timestamp'.
      * @return This builder.
      */
    public Builder setTimestamp(CharSequence value) {
      validate(fields()[1], value);
      this.timestamp = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'timestamp' field has been set.
      * @return True if the 'timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'timestamp' field.
      * @return This builder.
      */
    public Builder clearTimestamp() {
      timestamp = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'type' field.
      * @return The value.
      */
    public CharSequence getType() {
      return type;
    }

    /**
      * Sets the value of the 'type' field.
      * @param value The value of 'type'.
      * @return This builder.
      */
    public Builder setType(CharSequence value) {
      validate(fields()[2], value);
      this.type = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'type' field has been set.
      * @return True if the 'type' field has been set, false otherwise.
      */
    public boolean hasType() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'type' field.
      * @return This builder.
      */
    public Builder clearType() {
      type = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'value' field.
      * @return The value.
      */
    public CharSequence getValue() {
      return value;
    }

    /**
      * Sets the value of the 'value' field.
      * @param value The value of 'value'.
      * @return This builder.
      */
    public Builder setValue(CharSequence value) {
      validate(fields()[3], value);
      this.value = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'value' field has been set.
      * @return True if the 'value' field has been set, false otherwise.
      */
    public boolean hasValue() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'value' field.
      * @return This builder.
      */
    public Builder clearValue() {
      value = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SensorDataEntityAvro build() {
      try {
        SensorDataEntityAvro record = new SensorDataEntityAvro();
        record.device_id = fieldSetFlags()[0] ? this.device_id : (CharSequence) defaultValue(fields()[0]);
        record.timestamp = fieldSetFlags()[1] ? this.timestamp : (CharSequence) defaultValue(fields()[1]);
        record.type = fieldSetFlags()[2] ? this.type : (CharSequence) defaultValue(fields()[2]);
        record.value = fieldSetFlags()[3] ? this.value : (CharSequence) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<SensorDataEntityAvro>
    WRITER$ = (org.apache.avro.io.DatumWriter<SensorDataEntityAvro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<SensorDataEntityAvro>
    READER$ = (org.apache.avro.io.DatumReader<SensorDataEntityAvro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}