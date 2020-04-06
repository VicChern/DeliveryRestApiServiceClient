package com.softserve.itacademy.kek.rest.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class Order {

    @ApiModelProperty(value = "")
    private OrderDetails details = null;

    @ApiModelProperty(value = "")
    private String guid = null;

    @ApiModelProperty(value = "")
    private String summary = null;

    @ApiModelProperty(value = "")
    private String tenant = null;

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

    /**
     * Get details
     *
     * @return details
     **/
    @JsonProperty("details")
    public OrderDetails getDetails() {
        return details;
    }

    public void setDetails(OrderDetails details) {
        this.details = details;
    }

    public Order details(OrderDetails details) {
        this.details = details;
        return this;
    }

    /**
     * Get guid
     *
     * @return guid
     **/
    @JsonProperty("guid")
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Order guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * Get summary
     *
     * @return summary
     **/
    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Order summary(String summary) {
        this.summary = summary;
        return this;
    }

    /**
     * Get tenant
     *
     * @return tenant
     **/
    @JsonProperty("tenant")
    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public Order tenant(String tenant) {
        this.tenant = tenant;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Order {\n");

        sb.append("    details: ").append(toIndentedString(details)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
        sb.append("    tenant: ").append(toIndentedString(tenant)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    public static class ResponseEntity {

        @ApiModelProperty(value = "")
        private Object body = null;
        @ApiModelProperty(value = "")
        private StatusCodeEnum statusCode = null;
        @ApiModelProperty(value = "")
        private Integer statusCodeValue = null;

        /**
         * Convert the given object to string with each line indented by 4 spaces
         * (except the first line).
         */
        private static String toIndentedString(Object o) {
            if (o == null) {
                return "null";
            }
            return o.toString().replace("\n", "\n    ");
        }

        /**
         * Get body
         *
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
         *
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
         *
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

        @XmlType(name = "StatusCodeEnum")
        @XmlEnum(String.class)
        public enum StatusCodeEnum {

            @XmlEnumValue("100 CONTINUE") _100_CONTINUE("100 CONTINUE"), @XmlEnumValue("101 SWITCHING_PROTOCOLS") _101_SWITCHING_PROTOCOLS("101 SWITCHING_PROTOCOLS"), @XmlEnumValue("102 PROCESSING") _102_PROCESSING("102 PROCESSING"), @XmlEnumValue("103 CHECKPOINT") _103_CHECKPOINT("103 CHECKPOINT"), @XmlEnumValue("200 OK") _200_OK("200 OK"), @XmlEnumValue("201 CREATED") _201_CREATED("201 CREATED"), @XmlEnumValue("202 ACCEPTED") _202_ACCEPTED("202 ACCEPTED"), @XmlEnumValue("203 NON_AUTHORITATIVE_INFORMATION") _203_NON_AUTHORITATIVE_INFORMATION("203 NON_AUTHORITATIVE_INFORMATION"), @XmlEnumValue("204 NO_CONTENT") _204_NO_CONTENT("204 NO_CONTENT"), @XmlEnumValue("205 RESET_CONTENT") _205_RESET_CONTENT("205 RESET_CONTENT"), @XmlEnumValue("206 PARTIAL_CONTENT") _206_PARTIAL_CONTENT("206 PARTIAL_CONTENT"), @XmlEnumValue("207 MULTI_STATUS") _207_MULTI_STATUS("207 MULTI_STATUS"), @XmlEnumValue("208 ALREADY_REPORTED") _208_ALREADY_REPORTED("208 ALREADY_REPORTED"), @XmlEnumValue("226 IM_USED") _226_IM_USED("226 IM_USED"), @XmlEnumValue("300 MULTIPLE_CHOICES") _300_MULTIPLE_CHOICES("300 MULTIPLE_CHOICES"), @XmlEnumValue("301 MOVED_PERMANENTLY") _301_MOVED_PERMANENTLY("301 MOVED_PERMANENTLY"), @XmlEnumValue("302 FOUND") _302_FOUND("302 FOUND"), @XmlEnumValue("302 MOVED_TEMPORARILY") _302_MOVED_TEMPORARILY("302 MOVED_TEMPORARILY"), @XmlEnumValue("303 SEE_OTHER") _303_SEE_OTHER("303 SEE_OTHER"), @XmlEnumValue("304 NOT_MODIFIED") _304_NOT_MODIFIED("304 NOT_MODIFIED"), @XmlEnumValue("305 USE_PROXY") _305_USE_PROXY("305 USE_PROXY"), @XmlEnumValue("307 TEMPORARY_REDIRECT") _307_TEMPORARY_REDIRECT("307 TEMPORARY_REDIRECT"), @XmlEnumValue("308 PERMANENT_REDIRECT") _308_PERMANENT_REDIRECT("308 PERMANENT_REDIRECT"), @XmlEnumValue("400 BAD_REQUEST") _400_BAD_REQUEST("400 BAD_REQUEST"), @XmlEnumValue("401 UNAUTHORIZED") _401_UNAUTHORIZED("401 UNAUTHORIZED"), @XmlEnumValue("402 PAYMENT_REQUIRED") _402_PAYMENT_REQUIRED("402 PAYMENT_REQUIRED"), @XmlEnumValue("403 FORBIDDEN") _403_FORBIDDEN("403 FORBIDDEN"), @XmlEnumValue("404 NOT_FOUND") _404_NOT_FOUND("404 NOT_FOUND"), @XmlEnumValue("405 METHOD_NOT_ALLOWED") _405_METHOD_NOT_ALLOWED("405 METHOD_NOT_ALLOWED"), @XmlEnumValue("406 NOT_ACCEPTABLE") _406_NOT_ACCEPTABLE("406 NOT_ACCEPTABLE"), @XmlEnumValue("407 PROXY_AUTHENTICATION_REQUIRED") _407_PROXY_AUTHENTICATION_REQUIRED("407 PROXY_AUTHENTICATION_REQUIRED"), @XmlEnumValue("408 REQUEST_TIMEOUT") _408_REQUEST_TIMEOUT("408 REQUEST_TIMEOUT"), @XmlEnumValue("409 CONFLICT") _409_CONFLICT("409 CONFLICT"), @XmlEnumValue("410 GONE") _410_GONE("410 GONE"), @XmlEnumValue("411 LENGTH_REQUIRED") _411_LENGTH_REQUIRED("411 LENGTH_REQUIRED"), @XmlEnumValue("412 PRECONDITION_FAILED") _412_PRECONDITION_FAILED("412 PRECONDITION_FAILED"), @XmlEnumValue("413 PAYLOAD_TOO_LARGE") _413_PAYLOAD_TOO_LARGE("413 PAYLOAD_TOO_LARGE"), @XmlEnumValue("413 REQUEST_ENTITY_TOO_LARGE") _413_REQUEST_ENTITY_TOO_LARGE("413 REQUEST_ENTITY_TOO_LARGE"), @XmlEnumValue("414 URI_TOO_LONG") _414_URI_TOO_LONG("414 URI_TOO_LONG"), @XmlEnumValue("414 REQUEST_URI_TOO_LONG") _414_REQUEST_URI_TOO_LONG("414 REQUEST_URI_TOO_LONG"), @XmlEnumValue("415 UNSUPPORTED_MEDIA_TYPE") _415_UNSUPPORTED_MEDIA_TYPE("415 UNSUPPORTED_MEDIA_TYPE"), @XmlEnumValue("416 REQUESTED_RANGE_NOT_SATISFIABLE") _416_REQUESTED_RANGE_NOT_SATISFIABLE("416 REQUESTED_RANGE_NOT_SATISFIABLE"), @XmlEnumValue("417 EXPECTATION_FAILED") _417_EXPECTATION_FAILED("417 EXPECTATION_FAILED"), @XmlEnumValue("418 I_AM_A_TEAPOT") _418_I_AM_A_TEAPOT("418 I_AM_A_TEAPOT"), @XmlEnumValue("419 INSUFFICIENT_SPACE_ON_RESOURCE") _419_INSUFFICIENT_SPACE_ON_RESOURCE("419 INSUFFICIENT_SPACE_ON_RESOURCE"), @XmlEnumValue("420 METHOD_FAILURE") _420_METHOD_FAILURE("420 METHOD_FAILURE"), @XmlEnumValue("421 DESTINATION_LOCKED") _421_DESTINATION_LOCKED("421 DESTINATION_LOCKED"), @XmlEnumValue("422 UNPROCESSABLE_ENTITY") _422_UNPROCESSABLE_ENTITY("422 UNPROCESSABLE_ENTITY"), @XmlEnumValue("423 LOCKED") _423_LOCKED("423 LOCKED"), @XmlEnumValue("424 FAILED_DEPENDENCY") _424_FAILED_DEPENDENCY("424 FAILED_DEPENDENCY"), @XmlEnumValue("425 TOO_EARLY") _425_TOO_EARLY("425 TOO_EARLY"), @XmlEnumValue("426 UPGRADE_REQUIRED") _426_UPGRADE_REQUIRED("426 UPGRADE_REQUIRED"), @XmlEnumValue("428 PRECONDITION_REQUIRED") _428_PRECONDITION_REQUIRED("428 PRECONDITION_REQUIRED"), @XmlEnumValue("429 TOO_MANY_REQUESTS") _429_TOO_MANY_REQUESTS("429 TOO_MANY_REQUESTS"), @XmlEnumValue("431 REQUEST_HEADER_FIELDS_TOO_LARGE") _431_REQUEST_HEADER_FIELDS_TOO_LARGE("431 REQUEST_HEADER_FIELDS_TOO_LARGE"), @XmlEnumValue("451 UNAVAILABLE_FOR_LEGAL_REASONS") _451_UNAVAILABLE_FOR_LEGAL_REASONS("451 UNAVAILABLE_FOR_LEGAL_REASONS"), @XmlEnumValue("500 INTERNAL_SERVER_ERROR") _500_INTERNAL_SERVER_ERROR("500 INTERNAL_SERVER_ERROR"), @XmlEnumValue("501 NOT_IMPLEMENTED") _501_NOT_IMPLEMENTED("501 NOT_IMPLEMENTED"), @XmlEnumValue("502 BAD_GATEWAY") _502_BAD_GATEWAY("502 BAD_GATEWAY"), @XmlEnumValue("503 SERVICE_UNAVAILABLE") _503_SERVICE_UNAVAILABLE("503 SERVICE_UNAVAILABLE"), @XmlEnumValue("504 GATEWAY_TIMEOUT") _504_GATEWAY_TIMEOUT("504 GATEWAY_TIMEOUT"), @XmlEnumValue("505 HTTP_VERSION_NOT_SUPPORTED") _505_HTTP_VERSION_NOT_SUPPORTED("505 HTTP_VERSION_NOT_SUPPORTED"), @XmlEnumValue("506 VARIANT_ALSO_NEGOTIATES") _506_VARIANT_ALSO_NEGOTIATES("506 VARIANT_ALSO_NEGOTIATES"), @XmlEnumValue("507 INSUFFICIENT_STORAGE") _507_INSUFFICIENT_STORAGE("507 INSUFFICIENT_STORAGE"), @XmlEnumValue("508 LOOP_DETECTED") _508_LOOP_DETECTED("508 LOOP_DETECTED"), @XmlEnumValue("509 BANDWIDTH_LIMIT_EXCEEDED") _509_BANDWIDTH_LIMIT_EXCEEDED("509 BANDWIDTH_LIMIT_EXCEEDED"), @XmlEnumValue("510 NOT_EXTENDED") _510_NOT_EXTENDED("510 NOT_EXTENDED"), @XmlEnumValue("511 NETWORK_AUTHENTICATION_REQUIRED") _511_NETWORK_AUTHENTICATION_REQUIRED("511 NETWORK_AUTHENTICATION_REQUIRED");


            private String value;

            StatusCodeEnum(String v) {
                value = v;
            }

            public static StatusCodeEnum fromValue(String v) {
                for (StatusCodeEnum b : StatusCodeEnum.values()) {
                    if (String.valueOf(b.value).equals(v)) {
                        return b;
                    }
                }
                return null;
            }

            public String value() {
                return value;
            }

            @Override
            public String toString() {
                return String.valueOf(value);
            }
        }
    }
}

