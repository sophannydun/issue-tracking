package com.issue.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.issue.tracking.model.Branch;
import com.issue.tracking.model.User;
import com.issue.tracking.repository.retrofit.service.BranchService;

@Controller
public class BranchController {

	@Autowired
	private BranchService branchServiceImp;
	@GetMapping("/branch")
	public String allBranches(Model model){
		User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		/* String name = user.getUsername(); //get logged in username */
		model.addAttribute("loginUser", loginUser);
		System.out.println(branchServiceImp.findAllBranch());
		model.addAttribute("branches", branchServiceImp.findAllBranch());
		return "branch/branch";
	}
	@GetMapping("/branch/{branchId}")
	public String findBranchById(@PathVariable ("branchId") Integer branchId, Model model){
		User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Branch branch =null;
		model.addAttribute("loginUser", loginUser);
		if(branchId==null){
			branch= new Branch();
		}
		branch = branchServiceImp.findBranchById(branchId);
		System.out.println("Client Branch findBranchById " + branch);
		model.addAttribute("branch", branch);
		return "/branch/branchdetail";
	}
	
	@GetMapping("/branch/addBranch")
	public String createBranch(Model model){
		User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("loginUser", loginUser);
		return "/branch/addbranch";
	}
	
	@PostMapping("/branch/addBranch")
	public String actionCreateBranch(Branch branch){
		Boolean createbranch=false;
		if(branch==null){
			branch= new Branch();
		}
		createbranch=branchServiceImp.createBranch(branch);
		System.out.println(createbranch + " Created " + branch);
		return "redirect:/branch";
	}
	@GetMapping("/branch/edit/{branchId}")
	public String updateBranchById(@PathVariable ("branchId") Integer branchId,Model model){
		User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("loginUser", loginUser);
		Branch branch =null;
		if(branchId==null){
			branch= new Branch();
		}
		branch = branchServiceImp.findBranchById(branchId);
		System.out.println("Client Branch edit findBranchById " + branch);
		model.addAttribute("branch", branch);
		return "/branch/editbranch";
	}
	
	@PutMapping("/branch/edit")
	public String actionUpdateBranchById(Branch branch){
		Boolean updatebranch=false;
		System.out.println(updatebranch + " Update " + branch);
		updatebranch=branchServiceImp.updateBranchById(branch);
		return "redirect:/branch";
	}
	
	@DeleteMapping("/branch/remove/{branchId}")
	public String removeBranchById(@PathVariable("branchId") Integer branchId){
		Boolean removeStatus=false;
		if(branchId==null){
			System.out.println("Delete Faild Please input Branch ID to Delete!!!" + branchId );
		}
		removeStatus=branchServiceImp.removeBranchById(branchId);
		System.out.println(removeStatus + " Removed " + branchId);
		return "redirect:/branch";
		
	}
}
