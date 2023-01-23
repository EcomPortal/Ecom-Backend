package com.ecom.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.CustomResponse;
import com.ecom.app.dto.ForgetPasswordRequestDto;
import com.ecom.app.dto.LoginRequest;
import com.ecom.app.dto.LoginResponse;
import com.ecom.app.dto.SignUpRequest;
import com.ecom.app.enums.UserType;
import com.ecom.app.exception.UnauthorizedException;
import com.ecom.app.module.CredentialMaster;
import com.ecom.app.module.UserData;
import com.ecom.app.repository.CredentialMasterRepository;
import com.ecom.app.repository.UserDataRepository;
import com.ecom.app.security.JwtTokenUtil;
import com.ecom.app.security.JwtUserDetailsService;
import com.ecom.app.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private CredentialMasterRepository credentialMasterRepository;

	@Autowired
	private UserDataRepository userDataRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public LoginResponse login(LoginRequest loginRequest) throws Exception {
		LoginResponse loginResponse = new LoginResponse();

		UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());

		if (userDetails != null) {

			Optional<CredentialMaster> credentialMasterOptional = credentialMasterRepository
					.findByEmail(loginRequest.getUsername());

			if (credentialMasterOptional.isPresent()) {

				CredentialMaster credentialMaster = credentialMasterOptional.get();

				if (credentialMaster.passwordMatches(loginRequest.getPassword())) {
					for (UserType userType : UserType.values()) {
						if (credentialMaster.getUserTypeId().name().equalsIgnoreCase(userType.name())) {
							loginResponse.setId(credentialMaster.getId());
							loginResponse.setEmail(credentialMaster.getEmail());
							loginResponse.setUserName(credentialMaster.getName());
							loginResponse.setUserType(credentialMaster.getUserTypeId().name());
							loginResponse.setToken(jwtTokenUtil.generateToken(userDetails));
						}
					}

				} else {
					throw new UnauthorizedException("INVALID_CREDENTIALS");
				}
			}

			return loginResponse;
		} else {
			throw new Exception("Invalid Credential");
		}
	}

	@Override
	public CustomResponse registerUser(SignUpRequest signUpRequest) {
		try {
			List<CredentialMaster> credentialMasterDBList = credentialMasterRepository
					.findAllByPhoneNoEmail(signUpRequest.getPhoneNo(), signUpRequest.getPhoneNo());
			for (CredentialMaster credentialMaster : credentialMasterDBList) {
				if (credentialMaster.getEmail() != null && credentialMaster.getPhoneNo() != null
						&& (credentialMaster.getEmail().equals(signUpRequest.getEmail())
								|| credentialMaster.getPhoneNo().equals(signUpRequest.getPhoneNo())))
					return new CustomResponse(HttpStatus.BAD_REQUEST.value(), null,
							"Email and phone number cannot be duplicate !!!");
			}
			CredentialMaster credentialMasterSave = new CredentialMaster(null, signUpRequest.getUserName(),
					UserType.Customer, signUpRequest.getEmail(), signUpRequest.getPhoneNo(), null, null);
			credentialMasterSave.setPassword(credentialMasterSave.passwordEncoder(signUpRequest.getPassword()));
			UserData userDataSave = new UserData(null, signUpRequest.getUserName(), signUpRequest.getEmail(),
					signUpRequest.getPhoneNo(), true);
			userDataSave = userDataRepository.save(userDataSave);
			credentialMasterSave.setUserId(userDataSave.getId());
			credentialMasterSave = credentialMasterRepository.save(credentialMasterSave);
			if (credentialMasterSave != null)
				return new CustomResponse(HttpStatus.OK.value(), credentialMasterSave,
						"User Registered Succefully  !!!");
			else
				return new CustomResponse(HttpStatus.BAD_REQUEST.value(), null, "Failed in User Registeration!!!");

		} catch (Exception e) {
			return new CustomResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), null,
					"Register user service goes wrong.");
		}
	}

	@Override
	public CustomResponse forgetPassword(ForgetPasswordRequestDto forgetPassword) {
		Optional<CredentialMaster> userData=credentialMasterRepository.findByEmail(forgetPassword.getEmail());
		if(userData!=null && !userData.isEmpty()) {
			if(forgetPassword.getPassword().equals(forgetPassword.getRetypePassword())) {
				userData.get().setPassword(userData.get().passwordEncoder(forgetPassword.getPassword()));
			}
			
		}
		CustomResponse response=new CustomResponse();
		CredentialMaster master=credentialMasterRepository.save(userData.get());
		response.setMessage("Password Reset Succesful..");
		response.setStatus(HttpStatus.OK.value());
		return response;
	}

}