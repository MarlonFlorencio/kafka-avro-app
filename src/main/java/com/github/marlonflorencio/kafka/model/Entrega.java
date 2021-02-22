/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.github.marlonflorencio.kafka.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Entrega extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4260292688612760842L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Entrega\",\"namespace\":\"com.github.marlonflorencio.kafka.model\",\"fields\":[{\"name\":\"endereco\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"numero\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"cidade\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"status\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Entrega> ENCODER =
      new BinaryMessageEncoder<Entrega>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Entrega> DECODER =
      new BinaryMessageDecoder<Entrega>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Entrega> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Entrega> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Entrega> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Entrega>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Entrega to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Entrega from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Entrega instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Entrega fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String endereco;
   private java.lang.String numero;
   private java.lang.String cidade;
   private java.lang.String status;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Entrega() {}

  /**
   * All-args constructor.
   * @param endereco The new value for endereco
   * @param numero The new value for numero
   * @param cidade The new value for cidade
   * @param status The new value for status
   */
  public Entrega(java.lang.String endereco, java.lang.String numero, java.lang.String cidade, java.lang.String status) {
    this.endereco = endereco;
    this.numero = numero;
    this.cidade = cidade;
    this.status = status;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return endereco;
    case 1: return numero;
    case 2: return cidade;
    case 3: return status;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: endereco = value$ != null ? value$.toString() : null; break;
    case 1: numero = value$ != null ? value$.toString() : null; break;
    case 2: cidade = value$ != null ? value$.toString() : null; break;
    case 3: status = value$ != null ? value$.toString() : null; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'endereco' field.
   * @return The value of the 'endereco' field.
   */
  public java.lang.String getEndereco() {
    return endereco;
  }



  /**
   * Gets the value of the 'numero' field.
   * @return The value of the 'numero' field.
   */
  public java.lang.String getNumero() {
    return numero;
  }



  /**
   * Gets the value of the 'cidade' field.
   * @return The value of the 'cidade' field.
   */
  public java.lang.String getCidade() {
    return cidade;
  }



  /**
   * Gets the value of the 'status' field.
   * @return The value of the 'status' field.
   */
  public java.lang.String getStatus() {
    return status;
  }



  /**
   * Creates a new Entrega RecordBuilder.
   * @return A new Entrega RecordBuilder
   */
  public static com.github.marlonflorencio.kafka.model.Entrega.Builder newBuilder() {
    return new com.github.marlonflorencio.kafka.model.Entrega.Builder();
  }

  /**
   * Creates a new Entrega RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Entrega RecordBuilder
   */
  public static com.github.marlonflorencio.kafka.model.Entrega.Builder newBuilder(com.github.marlonflorencio.kafka.model.Entrega.Builder other) {
    if (other == null) {
      return new com.github.marlonflorencio.kafka.model.Entrega.Builder();
    } else {
      return new com.github.marlonflorencio.kafka.model.Entrega.Builder(other);
    }
  }

  /**
   * Creates a new Entrega RecordBuilder by copying an existing Entrega instance.
   * @param other The existing instance to copy.
   * @return A new Entrega RecordBuilder
   */
  public static com.github.marlonflorencio.kafka.model.Entrega.Builder newBuilder(com.github.marlonflorencio.kafka.model.Entrega other) {
    if (other == null) {
      return new com.github.marlonflorencio.kafka.model.Entrega.Builder();
    } else {
      return new com.github.marlonflorencio.kafka.model.Entrega.Builder(other);
    }
  }

  /**
   * RecordBuilder for Entrega instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Entrega>
    implements org.apache.avro.data.RecordBuilder<Entrega> {

    private java.lang.String endereco;
    private java.lang.String numero;
    private java.lang.String cidade;
    private java.lang.String status;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.github.marlonflorencio.kafka.model.Entrega.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.endereco)) {
        this.endereco = data().deepCopy(fields()[0].schema(), other.endereco);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.numero)) {
        this.numero = data().deepCopy(fields()[1].schema(), other.numero);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.cidade)) {
        this.cidade = data().deepCopy(fields()[2].schema(), other.cidade);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.status)) {
        this.status = data().deepCopy(fields()[3].schema(), other.status);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing Entrega instance
     * @param other The existing instance to copy.
     */
    private Builder(com.github.marlonflorencio.kafka.model.Entrega other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.endereco)) {
        this.endereco = data().deepCopy(fields()[0].schema(), other.endereco);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.numero)) {
        this.numero = data().deepCopy(fields()[1].schema(), other.numero);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.cidade)) {
        this.cidade = data().deepCopy(fields()[2].schema(), other.cidade);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.status)) {
        this.status = data().deepCopy(fields()[3].schema(), other.status);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'endereco' field.
      * @return The value.
      */
    public java.lang.String getEndereco() {
      return endereco;
    }


    /**
      * Sets the value of the 'endereco' field.
      * @param value The value of 'endereco'.
      * @return This builder.
      */
    public com.github.marlonflorencio.kafka.model.Entrega.Builder setEndereco(java.lang.String value) {
      validate(fields()[0], value);
      this.endereco = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'endereco' field has been set.
      * @return True if the 'endereco' field has been set, false otherwise.
      */
    public boolean hasEndereco() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'endereco' field.
      * @return This builder.
      */
    public com.github.marlonflorencio.kafka.model.Entrega.Builder clearEndereco() {
      endereco = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'numero' field.
      * @return The value.
      */
    public java.lang.String getNumero() {
      return numero;
    }


    /**
      * Sets the value of the 'numero' field.
      * @param value The value of 'numero'.
      * @return This builder.
      */
    public com.github.marlonflorencio.kafka.model.Entrega.Builder setNumero(java.lang.String value) {
      validate(fields()[1], value);
      this.numero = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'numero' field has been set.
      * @return True if the 'numero' field has been set, false otherwise.
      */
    public boolean hasNumero() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'numero' field.
      * @return This builder.
      */
    public com.github.marlonflorencio.kafka.model.Entrega.Builder clearNumero() {
      numero = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'cidade' field.
      * @return The value.
      */
    public java.lang.String getCidade() {
      return cidade;
    }


    /**
      * Sets the value of the 'cidade' field.
      * @param value The value of 'cidade'.
      * @return This builder.
      */
    public com.github.marlonflorencio.kafka.model.Entrega.Builder setCidade(java.lang.String value) {
      validate(fields()[2], value);
      this.cidade = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'cidade' field has been set.
      * @return True if the 'cidade' field has been set, false otherwise.
      */
    public boolean hasCidade() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'cidade' field.
      * @return This builder.
      */
    public com.github.marlonflorencio.kafka.model.Entrega.Builder clearCidade() {
      cidade = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'status' field.
      * @return The value.
      */
    public java.lang.String getStatus() {
      return status;
    }


    /**
      * Sets the value of the 'status' field.
      * @param value The value of 'status'.
      * @return This builder.
      */
    public com.github.marlonflorencio.kafka.model.Entrega.Builder setStatus(java.lang.String value) {
      validate(fields()[3], value);
      this.status = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'status' field has been set.
      * @return True if the 'status' field has been set, false otherwise.
      */
    public boolean hasStatus() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'status' field.
      * @return This builder.
      */
    public com.github.marlonflorencio.kafka.model.Entrega.Builder clearStatus() {
      status = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Entrega build() {
      try {
        Entrega record = new Entrega();
        record.endereco = fieldSetFlags()[0] ? this.endereco : (java.lang.String) defaultValue(fields()[0]);
        record.numero = fieldSetFlags()[1] ? this.numero : (java.lang.String) defaultValue(fields()[1]);
        record.cidade = fieldSetFlags()[2] ? this.cidade : (java.lang.String) defaultValue(fields()[2]);
        record.status = fieldSetFlags()[3] ? this.status : (java.lang.String) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Entrega>
    WRITER$ = (org.apache.avro.io.DatumWriter<Entrega>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Entrega>
    READER$ = (org.apache.avro.io.DatumReader<Entrega>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.endereco);

    out.writeString(this.numero);

    out.writeString(this.cidade);

    out.writeString(this.status);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.endereco = in.readString();

      this.numero = in.readString();

      this.cidade = in.readString();

      this.status = in.readString();

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.endereco = in.readString();
          break;

        case 1:
          this.numero = in.readString();
          break;

        case 2:
          this.cidade = in.readString();
          break;

        case 3:
          this.status = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










