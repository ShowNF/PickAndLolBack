package com.pickandlol.pickandlol.Service;

import com.pickandlol.pickandlol.Bean.*;
import com.pickandlol.pickandlol.Model.RequestMemberDeleteDTO;
import com.pickandlol.pickandlol.Model.RequestMemberImageUpdateDTO;
import com.pickandlol.pickandlol.Model.RequestMemberNameUpdateDTO;
import com.pickandlol.pickandlol.Model.RequestMemberRefreshTokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberService {

    GetAccessTokenBean getAccessTokenBean;
    ReissueAccessTokenBean reissueAccessTokenBean;
    UpdateMemberNameBean updateMemberNameBean;
    UpdateUserImageBean updateUserImageBean;
    DeleteMemberBean deleteMemberBean;

    @Autowired
    public MemberService(GetAccessTokenBean getAccessTokenBean, ReissueAccessTokenBean reissueAccessTokenBean, UpdateMemberNameBean updateMemberNameBean, UpdateUserImageBean updateUserImageBean, DeleteMemberBean deleteMemberBean) {
        this.getAccessTokenBean = getAccessTokenBean;
        this.reissueAccessTokenBean = reissueAccessTokenBean;
        this.updateMemberNameBean = updateMemberNameBean;
        this.updateUserImageBean = updateUserImageBean;
        this.deleteMemberBean = deleteMemberBean;
    }

    // 토큰 체크
    public Map<String, String> getAccessToken(String token) {
        System.out.println("token = " + token);
        return getAccessTokenBean.exec(token);
    }

    // 액세스 토큰 재발급
    public String reissueAccessToken(RequestMemberRefreshTokenDTO requestMemberRefreshTokenDTO) {
        return reissueAccessTokenBean.exec(requestMemberRefreshTokenDTO);
    }

    // 맴버 이름 변경
    public String updateMemberName(RequestMemberNameUpdateDTO requestMemberNameUpdateDTO) {
        return updateMemberNameBean.exec(requestMemberNameUpdateDTO);
    }

    // 맴버 이미지 변경
    public String updateUserImage(RequestMemberImageUpdateDTO requestMemberImageUpdateDTO) {
        return updateUserImageBean.exec(requestMemberImageUpdateDTO);
    }

    // 맴버 삭제
    public String deleteMember(RequestMemberDeleteDTO requestMemberDeleteDTO) {
        return deleteMemberBean.exec(requestMemberDeleteDTO);
    }
}
