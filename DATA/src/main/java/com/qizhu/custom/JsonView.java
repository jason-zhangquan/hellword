package com.qizhu.custom;
import java.io.IOException;  
  
import javax.servlet.http.HttpServletResponse;  
  
import org.springframework.http.MediaType;  
import org.springframework.http.converter.HttpMessageNotWritableException;  
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;  
import org.springframework.http.server.ServletServerHttpResponse;  
import org.springframework.web.servlet.ModelAndView;  
 
/**
 * 
 * @author Administrator
 *
 */
public class JsonView {  
    public static ModelAndView render(Object model, HttpServletResponse response)  
    {  
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();  
  
        MediaType jsonMimeType = MediaType.APPLICATION_JSON;  
  
  
        try {  
            jsonConverter.write(model, jsonMimeType, new ServletServerHttpResponse(response));  
        } catch (HttpMessageNotWritableException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
  
        return null;  
    }  
}  