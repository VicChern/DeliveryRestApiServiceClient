package com.softserve.itacademy.kek.rest.model;


import io.swagger.annotations.ApiModelProperty;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseEntity  {
  
  @ApiModelProperty(value = "")
  private Object body = null;


@XmlType(name="StatusCodeEnum")
@XmlEnum(String.class)
public enum StatusCodeEnum {

@XmlEnumValue("100 CONTINUE") _100_CONTINUE(String.valueOf("100 CONTINUE")), @XmlEnumValue("101 SWITCHING_PROTOCOLS") _101_SWITCHING_PROTOCOLS(String.valueOf("101 SWITCHING_PROTOCOLS")), @XmlEnumValue("102 PROCESSING") _102_PROCESSING(String.valueOf("102 PROCESSING")), @XmlEnumValue("103 CHECKPOINT") _103_CHECKPOINT(String.valueOf("103 CHECKPOINT")), @XmlEnumValue("200 OK") _200_OK(String.valueOf("200 OK")), @XmlEnumValue("201 CREATED") _201_CREATED(String.valueOf("201 CREATED")), @XmlEnumValue("202 ACCEPTED") _202_ACCEPTED(String.valueOf("202 ACCEPTED")), @XmlEnumValue("203 NON_AUTHORITATIVE_INFORMATION") _203_NON_AUTHORITATIVE_INFORMATION(String.valueOf("203 NON_AUTHORITATIVE_INFORMATION")), @XmlEnumValue("204 NO_CONTENT") _204_NO_CONTENT(String.valueOf("204 NO_CONTENT")), @XmlEnumValue("205 RESET_CONTENT") _205_RESET_CONTENT(String.valueOf("205 RESET_CONTENT")), @XmlEnumValue("206 PARTIAL_CONTENT") _206_PARTIAL_CONTENT(String.valueOf("206 PARTIAL_CONTENT")), @XmlEnumValue("207 MULTI_STATUS") _207_MULTI_STATUS(String.valueOf("207 MULTI_STATUS")), @XmlEnumValue("208 ALREADY_REPORTED") _208_ALREADY_REPORTED(String.valueOf("208 ALREADY_REPORTED")), @XmlEnumValue("226 IM_USED") _226_IM_USED(String.valueOf("226 IM_USED")), @XmlEnumValue("300 MULTIPLE_CHOICES") _300_MULTIPLE_CHOICES(String.valueOf("300 MULTIPLE_CHOICES")), @XmlEnumValue("301 MOVED_PERMANENTLY") _301_MOVED_PERMANENTLY(String.valueOf("301 MOVED_PERMANENTLY")), @XmlEnumValue("302 FOUND") _302_FOUND(String.valueOf("302 FOUND")), @XmlEnumValue("302 MOVED_TEMPORARILY") _302_MOVED_TEMPORARILY(String.valueOf("302 MOVED_TEMPORARILY")), @XmlEnumValue("303 SEE_OTHER") _303_SEE_OTHER(String.valueOf("303 SEE_OTHER")), @XmlEnumValue("304 NOT_MODIFIED") _304_NOT_MODIFIED(String.valueOf("304 NOT_MODIFIED")), @XmlEnumValue("305 USE_PROXY") _305_USE_PROXY(String.valueOf("305 USE_PROXY")), @XmlEnumValue("307 TEMPORARY_REDIRECT") _307_TEMPORARY_REDIRECT(String.valueOf("307 TEMPORARY_REDIRECT")), @XmlEnumValue("308 PERMANENT_REDIRECT") _308_PERMANENT_REDIRECT(String.valueOf("308 PERMANENT_REDIRECT")), @XmlEnumValue("400 BAD_REQUEST") _400_BAD_REQUEST(String.valueOf("400 BAD_REQUEST")), @XmlEnumValue("401 UNAUTHORIZED") _401_UNAUTHORIZED(String.valueOf("401 UNAUTHORIZED")), @XmlEnumValue("402 PAYMENT_REQUIRED") _402_PAYMENT_REQUIRED(String.valueOf("402 PAYMENT_REQUIRED")), @XmlEnumValue("403 FORBIDDEN") _403_FORBIDDEN(String.valueOf("403 FORBIDDEN")), @XmlEnumValue("404 NOT_FOUND") _404_NOT_FOUND(String.valueOf("404 NOT_FOUND")), @XmlEnumValue("405 METHOD_NOT_ALLOWED") _405_METHOD_NOT_ALLOWED(String.valueOf("405 METHOD_NOT_ALLOWED")), @XmlEnumValue("406 NOT_ACCEPTABLE") _406_NOT_ACCEPTABLE(String.valueOf("406 NOT_ACCEPTABLE")), @XmlEnumValue("407 PROXY_AUTHENTICATION_REQUIRED") _407_PROXY_AUTHENTICATION_REQUIRED(String.valueOf("407 PROXY_AUTHENTICATION_REQUIRED")), @XmlEnumValue("408 REQUEST_TIMEOUT") _408_REQUEST_TIMEOUT(String.valueOf("408 REQUEST_TIMEOUT")), @XmlEnumValue("409 CONFLICT") _409_CONFLICT(String.valueOf("409 CONFLICT")), @XmlEnumValue("410 GONE") _410_GONE(String.valueOf("410 GONE")), @XmlEnumValue("411 LENGTH_REQUIRED") _411_LENGTH_REQUIRED(String.valueOf("411 LENGTH_REQUIRED")), @XmlEnumValue("412 PRECONDITION_FAILED") _412_PRECONDITION_FAILED(String.valueOf("412 PRECONDITION_FAILED")), @XmlEnumValue("413 PAYLOAD_TOO_LARGE") _413_PAYLOAD_TOO_LARGE(String.valueOf("413 PAYLOAD_TOO_LARGE")), @XmlEnumValue("413 REQUEST_ENTITY_TOO_LARGE") _413_REQUEST_ENTITY_TOO_LARGE(String.valueOf("413 REQUEST_ENTITY_TOO_LARGE")), @XmlEnumValue("414 URI_TOO_LONG") _414_URI_TOO_LONG(String.valueOf("414 URI_TOO_LONG")), @XmlEnumValue("414 REQUEST_URI_TOO_LONG") _414_REQUEST_URI_TOO_LONG(String.valueOf("414 REQUEST_URI_TOO_LONG")), @XmlEnumValue("415 UNSUPPORTED_MEDIA_TYPE") _415_UNSUPPORTED_MEDIA_TYPE(String.valueOf("415 UNSUPPORTED_MEDIA_TYPE")), @XmlEnumValue("416 REQUESTED_RANGE_NOT_SATISFIABLE") _416_REQUESTED_RANGE_NOT_SATISFIABLE(String.valueOf("416 REQUESTED_RANGE_NOT_SATISFIABLE")), @XmlEnumValue("417 EXPECTATION_FAILED") _417_EXPECTATION_FAILED(String.valueOf("417 EXPECTATION_FAILED")), @XmlEnumValue("418 I_AM_A_TEAPOT") _418_I_AM_A_TEAPOT(String.valueOf("418 I_AM_A_TEAPOT")), @XmlEnumValue("419 INSUFFICIENT_SPACE_ON_RESOURCE") _419_INSUFFICIENT_SPACE_ON_RESOURCE(String.valueOf("419 INSUFFICIENT_SPACE_ON_RESOURCE")), @XmlEnumValue("420 METHOD_FAILURE") _420_METHOD_FAILURE(String.valueOf("420 METHOD_FAILURE")), @XmlEnumValue("421 DESTINATION_LOCKED") _421_DESTINATION_LOCKED(String.valueOf("421 DESTINATION_LOCKED")), @XmlEnumValue("422 UNPROCESSABLE_ENTITY") _422_UNPROCESSABLE_ENTITY(String.valueOf("422 UNPROCESSABLE_ENTITY")), @XmlEnumValue("423 LOCKED") _423_LOCKED(String.valueOf("423 LOCKED")), @XmlEnumValue("424 FAILED_DEPENDENCY") _424_FAILED_DEPENDENCY(String.valueOf("424 FAILED_DEPENDENCY")), @XmlEnumValue("425 TOO_EARLY") _425_TOO_EARLY(String.valueOf("425 TOO_EARLY")), @XmlEnumValue("426 UPGRADE_REQUIRED") _426_UPGRADE_REQUIRED(String.valueOf("426 UPGRADE_REQUIRED")), @XmlEnumValue("428 PRECONDITION_REQUIRED") _428_PRECONDITION_REQUIRED(String.valueOf("428 PRECONDITION_REQUIRED")), @XmlEnumValue("429 TOO_MANY_REQUESTS") _429_TOO_MANY_REQUESTS(String.valueOf("429 TOO_MANY_REQUESTS")), @XmlEnumValue("431 REQUEST_HEADER_FIELDS_TOO_LARGE") _431_REQUEST_HEADER_FIELDS_TOO_LARGE(String.valueOf("431 REQUEST_HEADER_FIELDS_TOO_LARGE")), @XmlEnumValue("451 UNAVAILABLE_FOR_LEGAL_REASONS") _451_UNAVAILABLE_FOR_LEGAL_REASONS(String.valueOf("451 UNAVAILABLE_FOR_LEGAL_REASONS")), @XmlEnumValue("500 INTERNAL_SERVER_ERROR") _500_INTERNAL_SERVER_ERROR(String.valueOf("500 INTERNAL_SERVER_ERROR")), @XmlEnumValue("501 NOT_IMPLEMENTED") _501_NOT_IMPLEMENTED(String.valueOf("501 NOT_IMPLEMENTED")), @XmlEnumValue("502 BAD_GATEWAY") _502_BAD_GATEWAY(String.valueOf("502 BAD_GATEWAY")), @XmlEnumValue("503 SERVICE_UNAVAILABLE") _503_SERVICE_UNAVAILABLE(String.valueOf("503 SERVICE_UNAVAILABLE")), @XmlEnumValue("504 GATEWAY_TIMEOUT") _504_GATEWAY_TIMEOUT(String.valueOf("504 GATEWAY_TIMEOUT")), @XmlEnumValue("505 HTTP_VERSION_NOT_SUPPORTED") _505_HTTP_VERSION_NOT_SUPPORTED(String.valueOf("505 HTTP_VERSION_NOT_SUPPORTED")), @XmlEnumValue("506 VARIANT_ALSO_NEGOTIATES") _506_VARIANT_ALSO_NEGOTIATES(String.valueOf("506 VARIANT_ALSO_NEGOTIATES")), @XmlEnumValue("507 INSUFFICIENT_STORAGE") _507_INSUFFICIENT_STORAGE(String.valueOf("507 INSUFFICIENT_STORAGE")), @XmlEnumValue("508 LOOP_DETECTED") _508_LOOP_DETECTED(String.valueOf("508 LOOP_DETECTED")), @XmlEnumValue("509 BANDWIDTH_LIMIT_EXCEEDED") _509_BANDWIDTH_LIMIT_EXCEEDED(String.valueOf("509 BANDWIDTH_LIMIT_EXCEEDED")), @XmlEnumValue("510 NOT_EXTENDED") _510_NOT_EXTENDED(String.valueOf("510 NOT_EXTENDED")), @XmlEnumValue("511 NETWORK_AUTHENTICATION_REQUIRED") _511_NETWORK_AUTHENTICATION_REQUIRED(String.valueOf("511 NETWORK_AUTHENTICATION_REQUIRED"));


    private String value;

    StatusCodeEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static StatusCodeEnum fromValue(String v) {
        for (StatusCodeEnum b : StatusCodeEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}

  @ApiModelProperty(value = "")
  private StatusCodeEnum statusCode = null;

  @ApiModelProperty(value = "")
  private Integer statusCodeValue = null;
 /**
   * Get body
   * @return body
  **/
  @JsonProperty("body")
  public Object getBody() {
    return body;
  }

  public void setBody(Object body) {
    this.body = body;
  }

  public ResponseEntity body(Object body) {
    this.body = body;
    return this;
  }

 /**
   * Get statusCode
   * @return statusCode
  **/
  @JsonProperty("statusCode")
  public String getStatusCode() {
    if (statusCode == null) {
      return null;
    }
    return statusCode.value();
  }

  public void setStatusCode(StatusCodeEnum statusCode) {
    this.statusCode = statusCode;
  }

  public ResponseEntity statusCode(StatusCodeEnum statusCode) {
    this.statusCode = statusCode;
    return this;
  }

 /**
   * Get statusCodeValue
   * @return statusCodeValue
  **/
  @JsonProperty("statusCodeValue")
  public Integer getStatusCodeValue() {
    return statusCodeValue;
  }

  public void setStatusCodeValue(Integer statusCodeValue) {
    this.statusCodeValue = statusCodeValue;
  }

  public ResponseEntity statusCodeValue(Integer statusCodeValue) {
    this.statusCodeValue = statusCodeValue;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseEntity {\n");
    
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    statusCodeValue: ").append(toIndentedString(statusCodeValue)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

