package com.huawei.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei.db.BodyProblemRepository;
import com.huawei.db.HeathDataRepository;
import com.huawei.db.SicknessProcessRepository;
import com.huawei.db.UserRepository;
import com.huawei.model.HeathData;
import com.huawei.model.User;

@Controller
@EnableAutoConfiguration
public class DoctorController {


	
	// #region login
	
	/**
	 * ע��ʱ�������û���Ϣ<br>
	 * @param user
	 */
	@RequestMapping("login/saveUserInfo")
    @ResponseBody
	public String saveUserInfo(@RequestBody User user){
		return "��ûʵ����";
	}
	
	/**
	 * ��¼ʱ,��ȡ�û���Ϣ<br>
	 * @param name
	 * @return
	 */
	@RequestMapping("login/queryUserInfo")
    @ResponseBody
	public User queryUserInfo(@RequestBody String name){
		return null;
	}
	
	/**
	 * ģ�������豸��ȡһ�ݽ�������<br>
	 * @param user
	 */
	@RequestMapping("login/setOneHeathData")
    @ResponseBody
	public void setOneHeathData(@RequestBody User user){
		HeathData heathData = fakeCollectHeathData();
		user.addHeathData(heathData);		
	}
	
	/**
	 * ���¼����б�,��ʼ����ʱ����<br>
	 * @param user
	 */
	@RequestMapping("login/updateSickness")
    @ResponseBody
	public void updateSickness(@RequestBody User user){
		
	}
	
	/**
	 * ���³�������,�������ھ�ϵͳ����<br>
	 * @param problem
	 */
	@RequestMapping("login/updateProblems")
    @ResponseBody
	public void updateProblems(@RequestBody String problem){
		
	}
	
	// #endregion
	
	// #region query problem
	
	/**
	 * ���ķִ�<br>
	 * @param words
	 * @return
	 */
	@RequestMapping("query/splitChineseWords")
    @ResponseBody
	public List<String> splitChineseWords(@RequestBody String words){
		return null;
	}
	
	/**
	 * ��ѯ����<br>
	 * @param words
	 * @return ��
	 */
	@RequestMapping("query/queryProblem")
    @ResponseBody
	public String queryProblem(@RequestBody String problem){
		return "";
	}
	
	// #endregion
	
	// #region sickness-help
	
	/**
	 * �������ѹ���<br>
	 * @param problem
	 * @return
	 */
	@RequestMapping("sicknessHelp/startWarn")
    @ResponseBody
	public String startWarn(@RequestBody String sickness){
		return "";
	}
	
	/**
	 * ����Ӧ������<br>
	 * @param problem
	 * @return
	 */
	@RequestMapping("sicknessHelp/startEmergency")
    @ResponseBody
	public String startEmergency(@RequestBody String sickness){
		return "";
	}
	
	// #endregion

	
	private HeathData fakeCollectHeathData() {
		HeathData heathData = new HeathData("", "");
		
		// TODO��������콡������
		
		return heathData;
	}
		
	
	// #region test
	
	@Autowired
	public static UserRepository userRepo;
	
	@Autowired
	public static SicknessProcessRepository sicknessRepo;
		
	@Autowired
	public static HeathDataRepository hdRepo;
	
	@Autowired
	public static BodyProblemRepository bpRepo;
	
	@RequestMapping("test")
    @ResponseBody
	public String test(){
		userRepo.deleteAll();

		// save a couple of customers
		userRepo.save(new User("zxc", "man", 30));
		userRepo.save(new User("vivi", "female", 28));

		// fetch all customers
		System.out.println("User found with findAll():");
		System.out.println("-------------------------------");
		
		String res = "";
		for (User user : userRepo.findAll()) {
			res += user.toString();
		}
		
		return res;
	}
}