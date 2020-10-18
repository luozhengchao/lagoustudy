package com.space.common.util.http;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.RequestFacade;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Enumeration;

/**
 * @Author LUOZHENGCHAO674
 * @Date 2020-1-17 14:59
 */
@Slf4j
public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private byte[] body;

    public BodyReaderHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        JSONObject params = new JSONObject();
        Enumeration e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = (String) e.nextElement();
            String value = request.getHeader(name);
            params.put(name, value);
        }
        log.info("BodyReaderHttpServletRequestWrapper={}", params.toJSONString());
        body = HttpHelper.getBodyString(request).getBytes(Charset.forName("UTF-8"));
    }

    public void resetBody(byte[] body) {
        if (this.getRequest() instanceof HttpServletRequestWrapper) {
            HttpServletRequestWrapper request1 = (HttpServletRequestWrapper) this.getRequest();
            RequestFacade requestFacade = (RequestFacade) request1.getRequest();
            try {
                Field field = RequestFacade.class.getDeclaredField("request");
                field.setAccessible(true);
                Request o = (Request) field.get(requestFacade);
                // 将Content-length放进去
                o.getCoyoteRequest().setContentLength(body.length);
                this.body = body;
            } catch (Exception e) {
                log.info("catch exception: ", e);
            }
        }
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream(), "UTF-8"));
    }

    public static ServletInputStream getInputStream(final byte[] body) {
        final ByteArrayInputStream bais = new ByteArrayInputStream(body);

        return new ServletInputStream() {
            /**
             * Has the end of this InputStream been reached?
             *
             * @return <code>true</code> if all the data has been read from the stream, else <code>false
             *     </code>
             * @since Servlet 3.1
             */
            @Override
            public boolean isFinished() {
                return false;
            }

            /**
             * Can data be read from this InputStream without blocking? Returns If this method is called
             * and returns false, the container will invoke {@link ReadListener#onDataAvailable()} when
             * data is available.
             *
             * @return <code>true</code> if data can be read without blocking, else <code>false</code>
             * @since Servlet 3.1
             */
            @Override
            public boolean isReady() {
                return false;
            }

            /**
             * Sets the {@link ReadListener} for this {@link ServletInputStream} and thereby switches to
             * non-blocking IO. It is only valid to switch to non-blocking IO within async processing or
             * HTTP upgrade processing.
             *
             * @param listener The non-blocking IO read listener
             * @throws IllegalStateException If this method is called if neither async nor HTTP upgrade is
             *     in progress or if the {@link ReadListener} has already been set
             * @throws NullPointerException If listener is null
             * @since Servlet 3.1
             */
            @Override
            public void setReadListener(ReadListener listener) {
            }

            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
    }

    @Override
    public ServletInputStream getInputStream() {

        final ByteArrayInputStream bais = new ByteArrayInputStream(body);

        return new ServletInputStream() {
            /**
             * Has the end of this InputStream been reached?
             *
             * @return <code>true</code> if all the data has been read from the stream, else <code>false
             *     </code>
             * @since Servlet 3.1
             */
            @Override
            public boolean isFinished() {
                return false;
            }

            /**
             * Can data be read from this InputStream without blocking? Returns If this method is called
             * and returns false, the container will invoke {@link ReadListener#onDataAvailable()} when
             * data is available.
             *
             * @return <code>true</code> if data can be read without blocking, else <code>false</code>
             * @since Servlet 3.1
             */
            @Override
            public boolean isReady() {
                return false;
            }

            /**
             * Sets the {@link ReadListener} for this {@link ServletInputStream} and thereby switches to
             * non-blocking IO. It is only valid to switch to non-blocking IO within async processing or
             * HTTP upgrade processing.
             *
             * @param listener The non-blocking IO read listener
             * @throws IllegalStateException If this method is called if neither async nor HTTP upgrade is
             *     in progress or if the {@link ReadListener} has already been set
             * @throws NullPointerException If listener is null
             * @since Servlet 3.1
             */
            @Override
            public void setReadListener(ReadListener listener) {
            }

            @Override
            public int read() {
                return bais.read();
            }
        };
    }

    @Override
    public String getHeader(String name) {
        return super.getHeader(name);
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        return super.getHeaderNames();
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        return super.getHeaders(name);
    }
}
