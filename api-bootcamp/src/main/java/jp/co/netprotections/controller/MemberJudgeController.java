package jp.co.netprotections.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeResponseDto;
import jp.co.netprotections.service.MemberJudgeService;

// WEBControllerとして機能するためのBean登録
@RestController
// リクエストURLの指定 ここは、コントローラーのクラス名と揃えるのか？
@RequestMapping("v1/member")
public class MemberJudgeController {
	@Autowired
	private MemberJudgeService memberJudgeService;
	
	@RequestMapping(value = "/judge", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public MemberJudgeResponseDto judge(@RequestBody MemberJudgeRequestDto requestDto) {
		return memberJudgeService.judgeCanidates(requestDto);
	}

}
