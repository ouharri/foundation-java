package io.soffa.foundation.core;

import io.soffa.foundation.core.models.Authentication;
import io.soffa.foundation.core.models.SideEffects;

import java.util.Map;
import java.util.Optional;

public interface RequestContext {
    String TENANT_ID = "X-TenantId";
    String APPLICATION = "X-Application";
    String TRACE_ID = "X-TraceId";
    String SPAN_ID = "X-SpanId";
    String SERVICE_NAME = "X-ServiceName";
    String AUTHORIZATION = "Authorization";

    Map<String, String> getHeaders();

    default void sync() {
        // TODO: Should we keep this ?
    }

    String getAuthorization();

    void setAuthorization(String value);

    default SideEffects getSideEffects() {
        return null;
    }

    Map<String, String> getContextMap();

    String getTenantId();

    void setTenantId(String value);

    boolean isAuthenticated();

    String getApplicationName();

    void setApplicationName(String value);

    String getSender();

    void setSender(String value);

    Optional<String> getUsername();

    boolean hasAuthorization();

    Authentication getAuthentication();

    void setAuthentication(Authentication auth);

    String getSpanId();

    void setSpanId(String value);

    String getTraceId();

    void setTraceId(String value);

    default RequestContext withAuthorization(String authorization) {
        setAuthorization(authorization);
        return this;
    }

    boolean hasTenant();

}
