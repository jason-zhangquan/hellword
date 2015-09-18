package com.qizhu.controller.user;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.qizhu.controller.base.BaseController;
import com.qizhu.model.user.User;
import com.qizhu.service.user.IUserService;
import com.qizhu.util.EncryptUtil;
import com.qizhu.util.Send;

/**
 * 用户操作相关
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/user")
public class OperUserController extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 456028171633247362L;

	//http://web.51welink.com官网
	private final String sname = "dlshqz00";
	private final String spwd = "BeTjtE66";
	private final String scorpid = "1012888";
	private final String URL = "http://cf.51welink.com/submitdata/Service.asmx/g_Submit";
	private final int SUCEESS = 1;
	private final int FAILURE = 0;

	@Autowired
	private IUserService userService;
	
	/**
	 * 根据Id,获取用户信息
	 * @return
	 */
	@RequestMapping(value = "/getUserInfoByUserId")
	@ResponseBody
	public Map<String, Object> getUserInfoByUserId(@RequestParam(value = "userId", required = true) String userId){
		Map<String, Object> map = new HashMap<String, Object>();
		User user =null;
		if(StringUtils.isNotEmpty(userId)){
			user = userService.get(userId);
		}
		map.put("user", user);
		return map;
	}
	

	/**
	 * 
	 * 手机发送验证码
	 * 
	 * @param map
	 * @param telephoneNumber
	 * @param registeWay
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */

	@RequestMapping(value = "/createCode")
	@ResponseBody
	public Map<String, Object> createCode(
			@RequestParam String telephoneNumber,
			@RequestParam(value = "registeWay", required = false) String registeWay,
			HttpServletRequest request,
			@RequestParam(value = "userId", required = false) String userId,
			HttpServletResponse response)
			throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		// 创建验证码
		int mobile_code = (int) ((Math.random() * 9 + 1) * 100000);

		// 1.判断是否已经注册
		User user = userService.getByProerties("telephoneNumber",
				telephoneNumber);

		if (user != null) {
			if (user.getIsRegiste() == 2) {// 已经注册成功了
				map.put("Result", FAILURE);// 已经注册了
				map.put("MessageInfo", "您的手机号已被注册！");// 已经注册了
			} else if (user.getIsRegiste() == 1) {// 曾经注册失败过
				user.setCodeTime(new Timestamp(new Date().getTime()));
				user.setCodeVal(mobile_code + "");
				userService.save(user);
				// 发送短信
				sentMassge(mobile_code, map, telephoneNumber);
			}

		} else {// 从未尝试注册过 ，但有匿名的情况,把匿名的信息调出来保存到当前用户
			
	    	if(StringUtils.isNotEmpty(userId)){
	    		user = userService.get(userId);
	    		log.debug("匿名的情况user=="+user);
	    		if(user==null){
	    			user = new User();
	    		}
	    	}else{
	    		user = new User();
	    	}
	    	user.setCodeTime(new Timestamp(new Date().getTime()));
	    	user.setRegisteWay(registeWay);
    		user.setCodeVal(mobile_code+"");
    		user.setTelephoneNumber(telephoneNumber);
    		userService.save(user);
			
			// 发送短信
			sentMassge(mobile_code, map, telephoneNumber);
		}
		return map;

	}

	/**
	 * 执行发送短信
	 * 
	 * @param mobile_code
	 */
	private void sentMassge(int mobile_code, Map<String, Object> map,
			String telephoneNumber) {

		String PostData = "sname=" + sname + "&spwd=" + spwd
				+ "&scorpid=&sprdid=" + scorpid + "&sdst=" + telephoneNumber
				+ "&smsg=" + "您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。【运势日历】";
		String ret = Send.SMS(PostData,
				URL);

		if (StringUtils.isNotEmpty(ret)) {
			System.out.println("验证码发送成功");
			System.out.println(ret);
			map.put("Result", SUCEESS);// 短信提交成功
			map.put("MessageInfo", "验证码发送成功！");// 短信提交成功
		}
	}

	/**
	 * 注册
	 * 
	 * @return register
	 * @throws Exception
	 */
	@RequestMapping(value = "/register")
	@ResponseBody
	public Map<String, Object> register(
			@RequestParam String telephoneNumber,
			@RequestParam(value = "registeWay", required = false) String registeWay,
			@RequestParam String password, @RequestParam String codeVal)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		log.debug("手机号==" + telephoneNumber);
		if (StringUtils.isNotEmpty(telephoneNumber)) {
			log.debug("手机号==" + telephoneNumber);
			User user = userService.getByProerties("telephoneNumber",
					telephoneNumber);
			if (user != null) {
				Date codeTime = user.getCodeTime();
				Date currentTime = new Date();
				long time = currentTime.getTime() - codeTime.getTime();// 当前时间与生成验证码的时间差
				// long failureTime =currentTime.getTime()+30*60*1000;
				log.debug("时间==" + time);
				log.debug(time - 30 * 60 * 1000);

				if (time > 30 * 60 * 1000) {// 过期，已经超过了30分钟
					map.put("Result", FAILURE);//
					map.put("MessageInfo", "验证码失效，请重新发送验证码！");// 短信提交成功
				} else {
					if (StringUtils
							.equalsIgnoreCase(user.getCodeVal(), codeVal)) {// 验证码验证成功
						user.setCreateTime(new Timestamp(new Date().getTime()));
						// 对密码进行SHA加密
						BigInteger sha = new BigInteger(
								EncryptUtil.encryptSHA(password.getBytes()));
						user.setPassword(sha.toString());

						user.setIsRegiste((short) 2);
						user.setCreateTime(new Timestamp(new Date().getTime()));
						user.setCodeVal(null);
						userService.update(user);

						map.put("Result", SUCEESS);// 短信提交成功
						map.put("MessageInfo", "注册成功，请登录！");// 短信提交成功
						map.put("user", user);
					} else {
						map.put("Result", FAILURE);//
						map.put("MessageInfo", "验证码错误，请重新输入验证码！");// 短信提交成功
					}
				}

			}
		}
		return map;
		// writeJson(map, request, response);

	}

	/**
	 * 
	 * 用户登录
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userLogin")
	@ResponseBody
	public Map<String, Object> userLogin(@RequestParam String telephoneNumber,
			@RequestParam String password) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotEmpty(telephoneNumber)
				&& StringUtils.isNotEmpty(password)) {
			// 对密码进行SHA加密
			BigInteger sha = new BigInteger(EncryptUtil.encryptSHA(password
					.getBytes()));

			User user = userService.getByProerties(new String[] {
					"telephoneNumber", "isRegiste" }, new Object[] {
					telephoneNumber, (short) 2 });
			if (user != null) {
				if (StringUtils.equalsIgnoreCase(user.getPassword(),
						sha.toString())) {
					map.put("Result", SUCEESS);// 短信提交成功
					map.put("MessageInfo", "登录成功!");// 短信提交成功
					map.put("user", user);
				} else {
					map.put("Result", FAILURE);// 短信提交成功
					map.put("MessageInfo", "手机号或密码错误！");// 短信提交成功
				}
			} else {
				map.put("Result", FAILURE);// 短信提交成功
				map.put("MessageInfo", "手机号未注册，请注册！");// 短信提交成功

			}
		}
		return map;
	}

	/**
	 * 
	 * 修改用户信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/editUserInfo")
	@ResponseBody
	public Map<String, Object> editUserInfo(
			User user,
			HttpServletRequest request,
//			@RequestParam(value = "logoPhoto", required = false) MultipartFile logoPhoto,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotEmpty(user.getUserId())) {
			log.debug("生日user.getUserId()===" + user.getUserId());

			User userOld = userService.get(user.getUserId());

			log.debug("生日userOld===" + userOld);
			log.debug("生日===" + userOld.getBirthTime());
			if (userOld != null) {// 402828ec4e759dbf014e759dd91f0000
				log.debug("birthTimes=====" + userOld.getBirthTime());
				// userOld.setBirthTime(user.getBirthTime());
				userOld.setNickName(user.getNickName());
				userOld.setUserSex(user.getUserSex());
				
				
				//创建一个通用的多部分解析器  
		        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext()); 
		        
		        //判断 request 是否有文件上传,即多部分请求  
		        if(multipartResolver.isMultipart(request)){   
		            //转换成多部分request    
		            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
		           
					
		            //取得request中的所有文件名  
		            Iterator<String> iter = multiRequest.getFileNames();  
		            while(iter.hasNext()){  
		                //记录上传过程起始时的时间，用来计算上传时间  
		                int pre = (int) System.currentTimeMillis();  
		                //取得上传文件  
		                MultipartFile multipartFile = multiRequest.getFile(iter.next());  
		                if(multipartFile != null){  
		                    //取得当前上传文件的文件名称  
		                	 String imageUrl;
		 					try {
		 						imageUrl = saveUploadFile(multipartFile,
		 								multipartFile.getOriginalFilename(), request);
		 						userOld.setImageUrl(imageUrl);
		 					} catch (Exception e) {
		 						map.put("Result", FAILURE);// 修改个人信息成功
		 						map.put("MessageInfo", "修改个人信息失败！");// 修改个人信息成功
		 						e.printStackTrace();
		 					}
		                }  
		                //记录上传该文件后的时间  
		                int finaltime = (int) System.currentTimeMillis();  
		                log.debug("上传时间"+(finaltime - pre));  
		            }  
		              
		        }  
		        
				userService.update(userOld);
				map.put("Result", SUCEESS);// 修改个人信息成功
				map.put("MessageInfo", "修改个人信息成功！");// 修改个人信息成功
			}
		} else {
			map.put("Result", FAILURE);// 修改个人信息成功
			map.put("MessageInfo", "修改个人信息失败！");// 修改个人信息成功
		}
		return map;
		// writeJson(map, request, response);
	}

	/**
	 * 
	 * 上传头像
	 * 
	 * 暂时没用到
	 * 
	 * @return
	 */
	@RequestMapping(value = "/loadImage")
	@ResponseBody
	public Map<String, Object> loadImage(
			@RequestParam String userId,
			HttpServletRequest request,
			@RequestParam("logoPhoto") MultipartFile logoPhoto,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotEmpty(userId)) {
			User user = userService.get(userId);
			if (user != null) {
				if (logoPhoto != null) {
					String imageUrl;
					try {
						imageUrl = saveUploadFile(logoPhoto,
								logoPhoto.getOriginalFilename(), request);
						user.setImageUrl(imageUrl);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					userService.save(user);
					map.put("Result", SUCEESS);// 修改个人信息成功
					map.put("MessageInfo", "上传成功！");// 修改个人信息成功
				}
			}
		}else{
			
			map.put("Result", FAILURE);// 
			map.put("MessageInfo", "上传失败！");// 
		}
		return map;
	}

	/**
	 * 修改密码时发送的验证码
	 * 
	 * @return
	 */
	@RequestMapping(value = "/editPasswordCode")
	@ResponseBody
	public Map<String, Object> editPasswordCode(
			@RequestParam String telephoneNumber) {
		Map<String, Object> map = new HashMap<String, Object>();
		int mobile_code = (int) ((Math.random() * 9 + 1) * 100000);

		// 1.判断是否存在
		log.debug("telephoneNumber-===================" + telephoneNumber);
		User user = userService.getByProerties("telephoneNumber",
				telephoneNumber);
		// search.addFilterEqual("isRegiste", 2);
		if (user != null && user.getIsRegiste() == 2) {
			user.setCodeTime(new Timestamp(new Date().getTime()));
			user.setCodeVal(mobile_code + "");
			userService.update(user);
			sentMassge(mobile_code, map, telephoneNumber);
		} else {
			map.put("Result", FAILURE);// 短信提交成功
			map.put("MessageInfo", "该用户不存在，请注册！");// 短信提交成功
		}
		return map;

	}

	/**
	 * 修改密码
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/editPassword")
	@ResponseBody
	public Map<String, Object> editPassword(
			@RequestParam String telephoneNumber,
			@RequestParam String codeVal,
			@RequestParam String password) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		// 1.判断是否已经注册
		log.debug("telephoneNumber-===================" + telephoneNumber);
		User user = userService.getByProerties("telephoneNumber",
				telephoneNumber);
		// search.addFilterEqual("isRegiste", 2);

		if (user != null) {

			if (user.getIsRegiste() != 2) {
				map.put("Result", FAILURE);
				map.put("MessageInfo", "该用户不存在，请注册！");
			} else {
				Date codeTime = user.getCodeTime();
				Date currentTime = new Date();
				long time = currentTime.getTime() - codeTime.getTime();// 当前时间与生成验证码的时间差
				// long failureTime =currentTime.getTime()+30*60*1000;
				log.debug("时间==" + time);
				log.debug(time - 30 * 60 * 1000);

				if (time > 30 * 60 * 1000) {// 过期，已经超过了30分钟
					map.put("Result", FAILURE);// 短信提交成功
					map.put("MessageInfo", "验证码失效，请重新发送验证码！");// 短信提交成功
				} else {
					if (StringUtils
							.equalsIgnoreCase(user.getCodeVal(), codeVal)) {// 验证码验证成功
						user.setCreateTime(new Timestamp(new Date().getTime()));
						// 对密码进行SHA加密
						BigInteger sha = new BigInteger(
								EncryptUtil.encryptSHA(password.getBytes()));
						user.setPassword(sha.toString());
						user.setCodeVal(null);
						userService.save(user);

						map.put("Result", SUCEESS);
						map.put("MessageInfo", "密码修改成功，请登录！");// 短信提交成功
						map.put("user", user);
					} else {
						map.put("Result", FAILURE);
						map.put("MessageInfo", "验证码错误，请重新输入验证码！");// 短信提交成功
					}
				}
			}
		} else {
			log.debug("该用户不存在，请注册！");
			map.put("Result", FAILURE);
			map.put("MessageInfo", "该用户不存在，请注册！");// 短信提交成功
		}
		return map;
	}
	

	/**
	 * 2015-05-12改版 微信授权登录
	 * 
	 * 说明：如果没授权过，就要新增一个用户，已经授权的用户，直接返回用户信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/wxLoginNew")
	@ResponseBody
	public Map<String, Object> wxLoginNew( 
			@RequestParam String wxId,
			@RequestParam String registeWay) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotEmpty(wxId)) {
			User user = userService.getByProerties("wxId", wxId);
			if (user != null) {// 已经绑定，允许登录
				map.put("Result", SUCEESS);
				map.put("MessageInfo", "登录成功");// 登录成功
				map.put("user", user);

			} else {//
				user = new User();
				user.setWxId(wxId);
				user.setCreateTime(new Timestamp(new Date().getTime()));
				user.setRegisteWay(registeWay);
				userService.save(user);
				map.put("Result", SUCEESS);
				map.put("MessageInfo", "登录成功");// 短信提交成功
				map.put("user", user);
			}
		}
		return map;
	}

	/**
	 * 废弃了
	 * 微信授权登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/wxLogin")
	@ResponseBody
	public Map<String, Object> wxLogin( 
			@RequestParam String wxId) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotEmpty(wxId)) {
			User user = userService.getByProerties("wxId", wxId);

			if (user != null) {// 已经绑定，允许登录
				map.put("Result", SUCEESS);
				map.put("MessageInfo", "登录成功");// 
				map.put("user", user);

			} else {// 还没有绑定，请绑定手机号
				map.put("Result", FAILURE);
				map.put("MessageInfo", "请先绑定手机号！");// 
			}
		}
		return map;
	}

	/**
	 * 
	 * 绑定手机号发送验证码校验
	 * 
	 * @return
	 */
	@RequestMapping(value = "/bindTelephoneCode")
	@ResponseBody
	public Map<String, Object> bindTelephoneCode(
			@RequestParam String telephoneNumber,
			@RequestParam String registeWay) {
		Map<String, Object> map = new HashMap<String, Object>();

		int mobile_code = (int) ((Math.random() * 9 + 1) * 100000);

		// 1.判断是否存在
		log.debug("telephoneNumber-===================" + telephoneNumber);

		User user = userService.getByProerties("telephoneNumber",
				telephoneNumber);
		if (user == null) {
			user = new User();
			user.setCodeTime(new Timestamp(new Date().getTime()));
			user.setCodeVal(mobile_code + "");
			user.setTelephoneNumber(telephoneNumber);
			user.setRegisteWay(registeWay);
			userService.save(user);
			// 发送短信
			sentMassge(mobile_code, map, telephoneNumber);
		} else {// 查到该手机号
			if (StringUtils.isNotEmpty(user.getWxId())) {// 判断该手机号是否绑定过微信
				map.put("Result", FAILURE);//
				map.put("MessageInfo", "该手机号已经绑定了微信！");// 短信提交成功
			} else {// 该手机虽然注册了，但尚未绑定微信，允许绑定，并发送验证码
				user.setCodeTime(new Timestamp(new Date().getTime()));
				user.setCodeVal(mobile_code + "");
				user.setTelephoneNumber(telephoneNumber);
				userService.update(user);
				// 发送短信
				sentMassge(mobile_code, map, telephoneNumber);
			}
		}

		return map;
	}

	/**
	 * 
	 * 绑定手机号
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/bindTelephone")
	@ResponseBody
	public Map<String, Object> bindTelephone(
			@RequestParam String telephoneNumber, 
			@RequestParam String codeVal,
			@RequestParam String wxId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// 1.判断是否已经注册
		log.debug("telephoneNumber-===================" + telephoneNumber);

		User user = userService.getByProerties("telephoneNumber",
				telephoneNumber);

		log.debug("用户=======" + user);
		if (user != null) {
			log.debug("用户=======" + user);

			Date codeTime = user.getCodeTime();
			Date currentTime = new Date();
			long time = currentTime.getTime() - codeTime.getTime();// 当前时间与生成验证码的时间差
			// long failureTime =currentTime.getTime()+30*60*1000;
			log.debug("时间==" + time);
			log.debug(time - 30 * 60 * 1000);

			if (time > 30 * 60 * 1000) {// 过期，已经超过了30分钟
				map.put("Result", FAILURE);//
				map.put("MessageInfo", "验证码失效，请重新发送验证码！");// 短信提交成功
			} else {
				if (StringUtils.equalsIgnoreCase(user.getCodeVal(), codeVal)) {// 验证码验证成功
					user.setWxId(wxId);
					// user.setIsRegiste(2);
					user.setCodeVal(null);
					userService.save(user);

					map.put("Result", SUCEESS);
					map.put("MessageInfo", "授权成功！");// 短信提交成功
					map.put("user", user);
				} else {
					map.put("Result", FAILURE);
					map.put("MessageInfo", "验证码错误，请重新输入验证码！");// 短信提交成功
				}
			}
		}
		return map;
	}

	/**
	 * 记录用户最后一次用系统的时间
	 * 
	 * @return
	 */
	@RequestMapping(value = "/recordLoginDateTime")
	@ResponseBody
	public Map<String, Object> recordLoginDateTime(
			@RequestParam(value="telephoneNumber",required=false) String telephoneNumber, 
			@RequestParam(value="wxId",required=false) String wxId) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = null;
		if (StringUtils.isNotEmpty(telephoneNumber)) {
			log.debug("telephoneNumber-===================" + telephoneNumber);
			user = userService.getByProerties("telephoneNumber",
					telephoneNumber);
		} else if (StringUtils.isNotEmpty(wxId)) {
			user = userService.getByProerties("wxId", wxId);
		}
		// search.addFilterEqual("isRegiste", 2);
		if (user != null) {
			int loginTimes = user.getLoginTimes();
			loginTimes++;
			user.setEndLoginTime(new Date());
			user.setLoginTimes(loginTimes);
			userService.save(user);
			map.put("Result", FAILURE);
			map.put("MessageInfo", "退出成功！");// 短信提交成功
		}

		return map;
	}
	
	

}
