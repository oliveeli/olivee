package com.olivee.hrmanager.web.action.orgnization;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestParam;import org.springframework.web.bind.annotation.ResponseBody;import com.olivee.hrmanager.web.entity.HrOrgnization;import com.olivee.hrmanager.web.logic.OrgnizationManagerLogic;import com.olivee.web.action.filter.WebAction;@Controller("orgnization.MainAction")public class MainAction implements WebAction{		@Autowired	private OrgnizationManagerLogic orgnizationManagerLogic;		@RequestMapping("/organization/list")	@ResponseBody	public List<HrOrgnization> orglist(@RequestParam("parentId") String parentId) {		return orgnizationManagerLogic.getOrgList(parentId);	}		@RequestMapping("/organization/create")	@ResponseBody	public HrOrgnization save(@RequestBody HrOrgnization organization) {		return orgnizationManagerLogic.save(organization);	}		@RequestMapping("/organization/update")	@ResponseBody	public HrOrgnization update(@RequestParam("model") HrOrgnization organization) {		return orgnizationManagerLogic.update(organization);	}		@RequestMapping("/organization/remove")	@ResponseBody	public List<HrOrgnization> remove(String parentId) {		return orgnizationManagerLogic.getOrgList(parentId);	}}