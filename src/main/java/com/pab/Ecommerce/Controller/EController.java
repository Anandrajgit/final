package com.pab.Ecommerce.Controller;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.pab.Ecommerce.BeanClass.CategoryDetails;
import com.pab.Ecommerce.BeanClass.CompanyDetails;
import com.pab.Ecommerce.BeanClass.Ebean;
import com.pab.Ecommerce.BeanClass.ProductDetails;
import com.pab.Ecommerce.Repository.Erepository;
import com.pab.Ecommerce.Service.CategoryService;
import com.pab.Ecommerce.Service.CompanyService;
import com.pab.Ecommerce.Service.ProductService;

@Controller
public class EController {

	@Autowired
	private Erepository repo;

	@Autowired
	CompanyService compService;

	@Autowired
	CategoryService cateService;
	
	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String home(HttpServletRequest request, Authentication authentication) {
		HttpSession session = request.getSession();
		session.setAttribute("sess", authentication.getName());
		Optional<Ebean> bean = repo.findByUserName(authentication.getName());
		String rol = bean.get().getRoles();
		if (rol.equals("ROLE_SELLER")) {
			return ("SellerAdmin");
		}
		return ("HomePage");
	}

	@GetMapping("/register")
	public String reg() {
		return ("Register");
	}

	@GetMapping("/about")
	public String about() {
		return ("About");
	}

	@GetMapping("/mobiledetails/{id}")
	public String tvList(@PathVariable("id") Long id, Model model,HttpServletRequest request, Authentication authentication) {
		HttpSession session = request.getSession();
		session.setAttribute("ldd",id);
		ProductDetails procdetails = productService.detailsById(id);
		model.addAttribute("details", procdetails);
		return ("Details");
	}
	
	@GetMapping("/onlinepay")
	public String onlinePayment( Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Long id=(Long)session.getAttribute("ldd");
		ProductDetails procdetails = productService.detailsById(id);
		model.addAttribute("details", procdetails);
		return ("BuyNow");
	}
	
	@GetMapping("/contact")
	public String contact() {
		return ("Contact");
	}

	@GetMapping("/MobileList")
	public String mobilelist(Model model) {
		List<ProductDetails> list = productService.getAllProduct();
		model.addAttribute("mobiList", list);
		return ("MobileList");
	}

//	@GetMapping("/downloadFile/{fileName:.+}")
//	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
//		ProductDetails databaseFile = fileStorageService.getFile(fileName);
//		return ResponseEntity.ok().contentType(MediaType.parseMediaType(databaseFile.getFileType()))
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getFileName() + "\"")
//				.body(new ByteArrayResource(databaseFile.getData()));
//	}

	@GetMapping("/TVList")
	public String tvlist() {
		return ("TVList");
	}
	
//	@GetMapping("/login")
//	public String login() {
//	    return ("Loginpage");
//  }

	@RequestMapping("/customerRegister")
	public String insert(Ebean user) {
		repo.save(user);
		return "Register";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");
		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");

		return "Loginpage";
	}

	@GetMapping("/selleradmin")
	public String sellerAdmin() {
		return ("SellerAdmin");
	}

	@GetMapping("/Sellogin")
	public String sell() {
		return ("Sellogin");
	}

	@RequestMapping("/company")
	public String viewCompanies(Model model) {
		List<CompanyDetails> list = compService.getAllCompany();
		model.addAttribute("compList", list);
		return ("ViewCompanies");
	}

	@RequestMapping("/add")
	public String addCompany(Model model) {
		model.addAttribute("companydetails", new CompanyDetails());
		return ("AddCompany");
	}

	@PostMapping("/result")
	public String viewResult(@ModelAttribute("companydetails") CompanyDetails company, Model model) {
		compService.insertRecords(company);
		List<CompanyDetails> list = compService.getAllCompany();
		model.addAttribute("compList", list);
		return ("redirect:/company");
	}

	@RequestMapping("/category")
	public String viewCategories(Model model) {
		List<CategoryDetails> list = cateService.getAllCategories();
		model.addAttribute("cateList", list);
		return ("ViewCategories");
	}

	@RequestMapping("/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("categorydetails", new CategoryDetails());
		return ("AddCategory");
	}

	@PostMapping("/cateresult")
	public String viewResult(@ModelAttribute("categorydetails") CategoryDetails category, Model model) {
		cateService.insertRecords(category);
		List<CategoryDetails> list = cateService.getAllCategories();
		model.addAttribute("cateList", list);
		return ("redirect:/category");
	}

	@GetMapping("/mobiles")
	public String add() {
		return ("ViewProducts");
	}
	

	@RequestMapping("/addproduct")
	public String addProduct(Model model) {
//		model.addAttribute("productdetails", new ProductDetails());
//		List<CompanyDetails> list = compService.getAllCompany();
//		model.addAttribute("compList", list);
//		List<CategoryDetails> list2 = cateService.getAllCategories();
//		model.addAttribute("cateList", list2);
		return ("AddProduct");
	}

}