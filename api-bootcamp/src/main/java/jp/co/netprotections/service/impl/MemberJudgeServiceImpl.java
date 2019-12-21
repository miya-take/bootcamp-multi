package jp.co.netprotections.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.netprotections.common.entity.Candidate;
import jp.co.netprotections.common.service.CommonMemberJudgeService;
import jp.co.netprotections.dto.CandidateJudgedResultDto;
import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeResponseDto;
import jp.co.netprotections.service.MemberJudgeService;

@Service
public class MemberJudgeServiceImpl implements MemberJudgeService {
	@Autowired 
	private CommonMemberJudgeService memberJudgeService;
	// ここで宣言すると、各判定対象の人のたびに、内容が更新されるけれど、この中でしか利用しないものだから良いのか？
	private CandidateJudgedResultDto judgedCandidate;
	private MemberJudgeResponseDto memberJudgeResultList;


	@Override
	public MemberJudgeResponseDto judgeCanidates(MemberJudgeRequestDto candidates) {
		// ResponseDtoへの橋渡しをするListオブジェクト
		List<CandidateJudgedResultDto> resultList = new ArrayList<CandidateJudgedResultDto>();
		for (Candidate candidate : candidates.getMemberCandidateList()) {
			judgedCandidate.setMemberName(candidate.getMemberName());
			judgedCandidate.setEnlistedPropriety(memberJudgeService.isCandidateExceededEnlistmentRequirements(candidate));
			resultList.add(judgedCandidate);
		}
		memberJudgeResultList.setResult(resultList);
		return memberJudgeResultList; 
	}

}
