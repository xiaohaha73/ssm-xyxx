package com.controller;

import com.pojo.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

// 管理员控制器
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private BanjiService banjiService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private PfblService pfblService; // 评分比例
    @Autowired
    private KechengService kechengService; // 课程
    @Autowired
    private XqService xqService; // 学期
    @Autowired
    private KeshiService keshiService; // 课时
    @Autowired
    private SksjService sksjService; // 上课时间
    @Autowired
    private KcbService kcbService; // 课程表


    // 加载管理员首页
    @RequestMapping("/index")
    public String index() {
        return "admin/index";
    }

    // 添加管理员界面
    @RequestMapping("/addpage")
    public String addPage() {
        return "admin/glyadd";
    }

    // 添加管理员接口
    @PostMapping("/add")
    public String addAdmin(HttpServletRequest req) {
        String yhm = req.getParameter("yhm"); // 用户名
        String mm = req.getParameter("mm"); // 密码
        String xm = req.getParameter("xm"); // 姓名
        if (yhm != null && mm != null && xm != null) {

            // 查询这个管理员是否存在数据库中
            com.pojo.Admin user = adminService.getAdminByYhm(yhm);
            if (user != null) {
                // 用户存在
                req.setAttribute("msg", "<script>alert('用户已经存在');</script>");//操作提示
                return "admin/glyadd";
            }

            com.pojo.Admin admin = new com.pojo.Admin(yhm, mm, xm);
            int ret = adminService.addAdmin(admin);
            if (ret > 0) {
                // 添加成功
                req.setAttribute("msg", "<script>alert('添加成功');</script>");//操作提示
            } else {
                req.setAttribute("msg", "<script>alert('添加失败');</script>");//操作提示
                return "admin/glyadd";
            }
        }

        return "redirect:/admin/listpage";
    }

    // 管理员列表界面
    @RequestMapping("/listpage")
    public String listPage(HttpServletRequest request, Model model) {
        // 获取到的页码
        Integer startIndex = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        // 获取每页显示条数
        Integer pageSize = request.getParameter("size") == null ? 4 : Integer.parseInt(request.getParameter("size"));
        // 查询所有的管理员数据
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        if (pageSize != 0) {
            map.put("startIndex", startIndex);
            map.put("pageSize", pageSize);
        }

        List<Admin> admins = adminService.getAdmins(map);
        model.addAttribute("list", admins);
        return "admin/glylist";
    }

    // 删除管理员
    @RequestMapping("/del")
    public String delAdmin(HttpServletRequest request) {
        // 获取管理员id
        int glyid = Integer.parseInt(request.getParameter("keyid"));
        int ret = adminService.delAdmin(glyid);
        if (ret > 0) {
            // 删除成功
            request.setAttribute("msg", "<script>alert('删除成功');</script>");
        } else {
            request.setAttribute("msg", "<script>alert('删除失败');</script>");
        }

        return "redirect:/admin/listpage";
    }


    // 编辑管理员界面
    @RequestMapping("/modifypage")
    public String editPage(HttpServletRequest request, Model model) {

        // 根据id值查询这个管理员
        int glyid = Integer.parseInt(request.getParameter("keyid"));
        Admin admin = adminService.getAdminById(glyid);

        String yhm = admin.getYhm();
        String mm = admin.getMm();
        String xm = admin.getXm();
        int glyid1 = admin.getGlyid();
        model.addAttribute("yhm", yhm);
        model.addAttribute("mm", mm);
        model.addAttribute("xm", xm);
        model.addAttribute("glyid", glyid1);
        return "admin/glymodify";
    }


    // 提交管理员修改
    @PostMapping("/update")
    public String updateAdmin(HttpServletRequest request) {

        String yhm = request.getParameter("yhm");
        String mm = request.getParameter("mm");
        String xm = request.getParameter("xm");
        int glyid = Integer.parseInt(request.getParameter("glyid"));

        Admin admin = new Admin();
        admin.setGlyid(glyid);
        admin.setYhm(yhm);
        admin.setMm(mm);
        admin.setXm(xm);
        int ret = adminService.updateAdmin(admin);
        if (ret > 0) {
            // 更新成功
            request.setAttribute("msg", "<script>alert('更新成功');</script>");
        } else {
            request.setAttribute("msg", "<script>alert('更新失败');</script>");
        }

        return "redirect:/admin/listpage";
    }


    // 加载管理员详情页面
    @RequestMapping("/detail")
    public String detail(HttpServletRequest request, Model model) {
        int glyid = Integer.parseInt(request.getParameter("keyid"));
        Admin admin = adminService.getAdminById(glyid);

        String yhm = admin.getYhm();
        String mm = admin.getMm();
        String xm = admin.getXm();
        model.addAttribute("yhm", yhm);
        model.addAttribute("mm", mm);
        model.addAttribute("xm", xm);
        model.addAttribute("glyid", glyid);

        return "/admin/glydetail";
    }


    // 添加老师页面
    @RequestMapping("/addteacher")
    public String addteacher() {
        return "/admin/jiaoshi/jiaoshiadd";
    }

    // 添加教师post请求
    @PostMapping("/addtea")
    public String addTea(HttpServletRequest request, Teacher teacher) {
        System.out.println(teacher);
        // String yhm = request.getParameter("yhm");//用户名

        // 查询是否存在该教师
        Teacher oldTeacher = teacherService.getTeacherByYhm(teacher.getYhm());
        if (oldTeacher != null) {
            request.setAttribute("msg", "<script>alert('该用户已经存在');</script>");
            return "redirect:/admin/addteacher";
        }

        // 存储老师
        int ret = teacherService.addTeacher(teacher);
        if (ret < 0 ) {
            request.setAttribute("msg", "<script>alert('添加失败');</script>");
            return "redirect:/admin/addteacher";
        }

        request.setAttribute("msg", "<script>alert('添加成功');</script>");
        return "redirect:/admin/teacherlist";
    }

    // 教师列表
    @RequestMapping("/teacherlist")
    public String teacherlist(Model model) {
        // 查询所有教师
        List<Teacher> teachers = teacherService.getTeachers();
        model.addAttribute("list",teachers);
        return "/admin/jiaoshi/jiaoshilist";
    }

    // 删除教师操作
    @RequestMapping("/delteacher")
    public String delTeacher(HttpServletRequest request) {
        int jsid = Integer.parseInt(request.getParameter("keyid"));
        // 调用service层
        int ret = teacherService.delTeacher(jsid);
        if (ret > 0 ) {
            // 删除成功
            request.setAttribute("msg", "<script>alert('删除成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('删除失败');</script>");
        }
        return "redirect:/admin/teacherlist";
    }


    // 修改教师页面
    @RequestMapping("/updateteapage")
    public String updateTeaPage(HttpServletRequest request, Model model) {
        // 获取传递过来的教师id
        int jsid = Integer.parseInt(request.getParameter("keyid"));
        // 查询出教师的信息
        Teacher teacher = teacherService.getTeacherById(jsid);
        model.addAttribute("jsid",teacher.getJsid());
        model.addAttribute("yhm",teacher.getYhm());
        model.addAttribute("xm",teacher.getXm());
        model.addAttribute("mm",teacher.getYhm());
        model.addAttribute("lxdh",teacher.getLxdh());
        model.addAttribute("lxdz",teacher.getLxdz());
        model.addAttribute("xy",teacher.getXy());
        return "/admin/jiaoshi/editpage";
    }

    // 更新教师
    @PostMapping("/updateteacher")
    public String updateTeacher(Teacher teacher,HttpServletRequest request) {
        // System.out.println(teacher);
        int ret = teacherService.updateTeacher(teacher);
        if (ret > 0) {
            // 更新成功
            request.setAttribute("msg", "<script>alert('更新成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('删除成功');</script>");
        }

        return "redirect:/admin/teacherlist";
    }

    // 展示教师详细信息的页面
    @RequestMapping("/teacherdetail")
    public String teaDetail(Model model,HttpServletRequest request) {
        // 获取传递过来的教师id
        int jsid = Integer.parseInt(request.getParameter("keyid"));
        // 查询出教师的信息
        Teacher teacher = teacherService.getTeacherById(jsid);
        model.addAttribute("jsid",teacher.getJsid());
        model.addAttribute("yhm",teacher.getYhm());
        model.addAttribute("xm",teacher.getXm());
        model.addAttribute("mm",teacher.getYhm());
        model.addAttribute("lxdh",teacher.getLxdh());
        model.addAttribute("lxdz",teacher.getLxdz());
        model.addAttribute("xy",teacher.getXy());
        return "/admin/jiaoshi/jiaoshidetail";
    }


    // 添加班级页面
    @RequestMapping("/addbanji")
    public String addbanjiPage() {
        return "/admin/banji/addbanji";
    }


    // 展示班级列表
    @RequestMapping("/banjilist")
    public String banjiList (Model model) {
        // 获取所有的班级数据
        List<Banji> lists = banjiService.getBanjis();
        model.addAttribute("list",lists);
        return "/admin/banji/banjis";
    }

    // 添夹班级请求
    @PostMapping("/addbanji")
    public String addbanji (Banji banji,HttpServletRequest request) {
        // 调用添加班级service
        int ret = banjiService.addBanji(banji);
        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('添加成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('添加失败');</script>");
        }

        return "redirect:/admin/banjilist";
    }


    // 修改班级界面
    @RequestMapping("/editbanji")
    public String editbanjiPage (HttpServletRequest request,Model model) {

        int bjid = Integer.parseInt(request.getParameter("keyid"));
        // 查询这个班级的信息
        Banji banji = banjiService.getBanjiByid(bjid);
        model.addAttribute("bjid",banji.getBjid());
        model.addAttribute("bj",banji.getBj());
        return "/admin/banji/editbanji";
    }

    // 提交班级修改的接口
    @PostMapping("/editbanji")
    public String editbanji (Banji banji,HttpServletRequest request) {
        int ret = banjiService.updateBanji(banji);
        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('修改成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('修改失败');</script>");
        }
        return "redirect:/admin/banjilist";
    }

    // 展示班级详情页面
    @RequestMapping("/banjidetail")
    public String banjiDetail (HttpServletRequest request, Model model) {
        int bjid = Integer.parseInt(request.getParameter("keyid"));
        // 查询这个班级的信息
        Banji banji = banjiService.getBanjiByid(bjid);
        model.addAttribute("bjid",banji.getBjid());
        model.addAttribute("bj",banji.getBj());
        return "/admin/banji/banjidetail";
    }

    // 删除班级
    @RequestMapping("/delbanji")
    public String delBanji (HttpServletRequest request, Model model) {
        int bjid = Integer.parseInt(request.getParameter("keyid"));
        int ret = banjiService.delBanji(bjid);
        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('删除成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('删除失败');</script>");
        }

        return "redirect:/admin/banjilist";
    }


    // 添加学生界面 addStuPage
    @RequestMapping("/addstupage")
    public String addStuPage (Model model) {
        // 查询出所有的班级
        List<Banji> banjis = banjiService.getBanjis();
        model.addAttribute("banjis",banjis);
        return "admin/xuesheng/addStudent";
    }

    // 添加学生接口
    @PostMapping("/addstudent")
    public String addStudent(Student student, HttpServletRequest request) {
        // System.out.println(student);
        int ret = studentService.addStudent(student);
        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('添加成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('添加失败');</script>");
        }

        return "redirect:/admin/studentspage";
    }


    // 学生列表界面 studentList
    @RequestMapping("/studentspage")
    public String studentsPage (Model model) {
        // 查询所有的学生
        List<Student> students = studentService.getStudents();
        model.addAttribute("list",students);
        return "admin/xuesheng/studentsList";
    }


    // 删除学生接口
    @RequestMapping("delstudent")
    public String delStudent (HttpServletRequest request) {
        int xsid = Integer.parseInt(request.getParameter("keyid"));
        int ret = studentService.delStudent(xsid);
        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('删除成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('删除失败');</script>");
        }

        return "redirect:/admin/studentspage";

    }


    // 跳转学生编辑界面
    @RequestMapping("editstupage")
    public String editStudent (HttpServletRequest request,Model model) {
        // 查询出所有的班级
        List<Banji> banjis = banjiService.getBanjis();
        model.addAttribute("banjis",banjis);

        // 根据id查询这个学生的信息
        int xsid = Integer.parseInt(request.getParameter("keyid"));
        Student student = studentService.getStudentById(xsid);
        model.addAttribute("xsid",student.getXsid());
        model.addAttribute("yhm",student.getYhm());
        model.addAttribute("mm",student.getMm());
        model.addAttribute("xm",student.getXm());
        model.addAttribute("zy",student.getZy());
        model.addAttribute("xy",student.getXy());
        model.addAttribute("nl",student.getNl());
        model.addAttribute("dh",student.getDh());
        model.addAttribute("bj",student.getBj());

        return "/admin/xuesheng/editStudent";
    }

    // 提交修改处理
    @PostMapping("/editstudent")
    public String editStu (Student student,HttpServletRequest request) {

        // System.out.println(student);
        int ret = studentService.updateStudent(student);
        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('修改成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('修改失败');</script>");
        }

        return "redirect:/admin/studentspage";
    }

    // 展示学生的详细信息
    @RequestMapping("/studentdetail")
    public String stuDetail (HttpServletRequest request,Model model) {
        // 根据id查询这个学生的信息
        int xsid = Integer.parseInt(request.getParameter("keyid"));
        Student student = studentService.getStudentById(xsid);
        model.addAttribute("xsid",student.getXsid());
        model.addAttribute("yhm",student.getYhm());
        model.addAttribute("mm",student.getMm());
        model.addAttribute("xm",student.getXm());
        model.addAttribute("zy",student.getZy());
        model.addAttribute("xy",student.getXy());
        model.addAttribute("nl",student.getNl());
        model.addAttribute("dh",student.getDh());
        model.addAttribute("bj",student.getBj());

        return "/admin/xuesheng/studentDetail";
    }



    // 添加评分比例页面
    @RequestMapping("/pfblpage")
    public String pfblPage () {
        return "/admin/pfbl/addpfbl";
    }


    // 添加评分比例请求
    @PostMapping("/addpfbl")
    public String addPfbl (Pfbl pfbl,HttpServletRequest request) {
        // System.out.println(pfbl);
        int ret = pfblService.insert(pfbl);
        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('添加成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('添加失败');</script>");
        }

        return "redirect:/admin/pfbllist";
    }


    // 评分比例列表
    @RequestMapping("/pfbllist")
    public String pfblList (Model model) {

        // 查询所有的评分比例列表
        List<Pfbl> pfbls = pfblService.listAll();
        model.addAttribute("list",pfbls);

        return "/admin/pfbl/pfblList";
    }


    // 修改评分比例页面
    @RequestMapping("/editpfbl")
    public String editPfbl (HttpServletRequest request,Model model) {
        // 根据id查询评分标准
        int pfblid = Integer.parseInt(request.getParameter("keyid"));
        Pfbl pfbl = pfblService.getById(pfblid);
        model.addAttribute("ps",pfbl.getPs());
        model.addAttribute("qm",pfbl.getQm());
        model.addAttribute("mc",pfbl.getMc());
        model.addAttribute("pfblid",pfbl.getPfblid());

        return "/admin/pfbl/editpfbl";
    }

    // 提交修改的请求
    @PostMapping("/editpfbl")
    public String updatePfbl (Pfbl pfbl,HttpServletRequest request) {
        int ret = pfblService.update(pfbl);
        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('添加成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('添加失败');</script>");
        }

        return "redirect:/admin/pfbllist";
    }


    // 删除评分标准
    @RequestMapping("/delpfbl")
    public String delPfbl (HttpServletRequest request) {
        int pfblid = Integer.parseInt(request.getParameter("keyid"));
        int ret = pfblService.delete(pfblid);

        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('添加成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('添加失败');</script>");
        }

        return "redirect:/admin/pfbllist";

    }


    // 评分详情页面
    @RequestMapping("/pfbldetail")
    public String pfblDetail (HttpServletRequest request, Model model) {
        int pfblid = Integer.parseInt(request.getParameter("keyid"));
        Pfbl pfbl = pfblService.getById(pfblid);
        model.addAttribute("ps",pfbl.getPs());
        model.addAttribute("qm",pfbl.getQm());
        model.addAttribute("mc",pfbl.getMc());
        model.addAttribute("pfblid",pfbl.getPfblid());

        return "/admin/pfbl/pfbldetail";
    }



    // 添加课程页面
    @RequestMapping("/addkepage")
    public String addKePage(Model model) {
        // 查询出所有的评分比例
        List<Pfbl> pfbls = pfblService.listAll();
        model.addAttribute("pfbls",pfbls);
        return "/admin/kecheng/kechengadd";
    }

    // 添加课程接口
    @RequestMapping("/addkecheng")
    public String addKe (Kecheng kecheng,HttpServletRequest request) {
//        System.out.println(kecheng);
        int ret = kechengService.insert(kecheng);
        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('添加成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('添加失败');</script>");
        }
        return "redirect:/admin/kelistpage";
    }



    // 展示所有课程列表的页面
    @RequestMapping("/kelistpage")
    public String keListPage (Model model) {

        // 查询所有的课程
        List<Kecheng> kechengs = kechengService.listAll();
        model.addAttribute("list",kechengs);
        return "/admin/kecheng/kechenglist";
    }


    // 课程删除接口
    @RequestMapping("delke")
    public String delKe (HttpServletRequest request) {
        int keyid = Integer.parseInt(request.getParameter("keyid"));
        int ret = kechengService.delete(keyid);
        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('删除成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('删除失败');</script>");
        }
        return "redirect:/admin/kelistpage";
    }


    // 课程编辑界面的展示
    @RequestMapping("/editke")
    public String editKe (HttpServletRequest request, Model model) {
        // 根据id查询出课程
        int keyid = Integer.parseInt(request.getParameter("keyid"));
        Kecheng kecheng = kechengService.getById(keyid);
        model.addAttribute("kcid",kecheng.getKcid());
        model.addAttribute("kcmc",kecheng.getKcmc());
        model.addAttribute("js",kecheng.getJs());
        model.addAttribute("fbjs",kecheng.getFbjs());
        model.addAttribute("bl",kecheng.getBl());

        // 查询出评分比例
        List<Pfbl> pfbls = pfblService.listAll();
        model.addAttribute("pfbls",pfbls);

        return "/admin/kecheng/kechengedit";
    }

    // 修改课程接口
    @PostMapping("/editke")
    public String editKecheng (Kecheng kecheng,HttpServletRequest request) {
        int ret = kechengService.update(kecheng);
        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('更新成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('更新失败');</script>");
        }
        return "redirect:/admin/kelistpage";
    }


    // 课程详情页面
    @RequestMapping("kedetail")
    public String keDetail (HttpServletRequest request, Model model) {
        // 根据id查询出课程
        int keyid = Integer.parseInt(request.getParameter("keyid"));
        Kecheng kecheng = kechengService.getById(keyid);
        model.addAttribute("kcid",kecheng.getKcid());
        model.addAttribute("kcmc",kecheng.getKcmc());
        model.addAttribute("js",kecheng.getJs());
        model.addAttribute("fbjs",kecheng.getFbjs());
        model.addAttribute("bl",kecheng.getBl());
        return "/admin/kecheng/kechengdetail";
    }



    // 添加上课时间界面
    @RequestMapping("/addtimepage")
    public String addTimePage (Model model) {
        // 查询所有的课程
        List<Kecheng> kechengs = kechengService.listAll();
        model.addAttribute("kelist",kechengs);
        // 查找所有的学时
        List<Keshi> keshis = keshiService.listAll();
        model.addAttribute("keshiList",keshis);
        // 查找所有星期
        List<Xq> xqs = xqService.listAll();
        model.addAttribute("xqList",xqs);
        return "/admin/sksj/timeadd";
    }

    // 添加上课时间的接口
    @PostMapping("/addtime")
    public String addTime (Sksj sksj, HttpServletRequest request) {
//        System.out.println(sksj);
        int ret = sksjService.insert(sksj);
        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('更新成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('更新失败');</script>");
        }
        return "redirect:/admin/timePage";
    }


    // 上课时间列表界面
    @RequestMapping("/timePage")
    public String timePage (Model model) {

        // 查询上课时间
        List<Sksj> list = sksjService.listAll();
        model.addAttribute("list",list);
        return "/admin/sksj/timelist";
    }

    // 删除上课时间
    @RequestMapping("/deltime")
    public String delTime (HttpServletRequest request) {
        int sksjid = Integer.parseInt(request.getParameter("keyid"));
        int ret = sksjService.delete(sksjid);
        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('删除成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('删除失败');</script>");
        }
        return "redirect:/admin/timePage";
    }


    // 编辑上课时间页面
    @RequestMapping("/modtimepage")
    public String editTime (HttpServletRequest request, Model model) {

        int sksjid = Integer.parseInt(request.getParameter("keyid"));
        // 查询出上课时间
        Sksj sksj = sksjService.getById(sksjid);
        model.addAttribute("sksjid",sksjid);
        model.addAttribute("kc",sksj.getKc());
        model.addAttribute("xq",sksj.getXq());
        model.addAttribute("j",sksj.getJ());

        // 查询所有的课程
        List<Kecheng> kechengs = kechengService.listAll();
        model.addAttribute("kelist",kechengs);
        // 查找所有的学时
        List<Keshi> keshis = keshiService.listAll();
        model.addAttribute("keshiList",keshis);
        // 查找所有星期
        List<Xq> xqs = xqService.listAll();
        model.addAttribute("xqList",xqs);

        return "/admin/sksj/timeedit";
    }

    // 编辑上课时间接口
    @PostMapping("/modtime")
    public String modTime (Sksj sksj,HttpServletRequest request) {

        int ret = sksjService.insert(sksj);
        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('编辑成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('编辑失败');</script>");
        }
        return "redirect:/admin/timePage";
    }

    // 上课时间详情页面
    @RequestMapping("/detailtime")
    public String detailTime (HttpServletRequest request,Model model) {
        int sksjid = Integer.parseInt(request.getParameter("keyid"));
        Sksj sksj = sksjService.getById(sksjid);
        model.addAttribute("sksjid",sksjid);
        model.addAttribute("kc",sksj.getKc());
        model.addAttribute("xq",sksj.getXq());
        model.addAttribute("j",sksj.getJ());
        return "/admin/sksj/detail";
    }


    // 添加课程表
    @RequestMapping("/kcbaddpage")
    public String kcbaddPage (Model model) {
        // 获取所有的课程名称
        List<Kecheng> kechengList = kechengService.listAll();
        model.addAttribute("keList",kechengList);

        // 获取所有的课程时间
        List<Keshi> keshiList = keshiService.listAll();
        model.addAttribute("keshiList",keshiList);
        return "/admin/kcb/kcbadd";
    }


    // 添加课程表操作
    @PostMapping("/addkcb")
    public String addKcb (HttpServletRequest request,Kcb kcb) {
        int ret = kcbService.insert(kcb);
        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('添加成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('添加失败');</script>");
        }
        return "redirect:/admin/kcblistpage";
    }


    // 课程表列表页面
    @RequestMapping("/kcblistpage")
    public String kcblistPage (Model model) {

        List<Kcb> kcbs = kcbService.listAll();
        model.addAttribute("list",kcbs);

        return "/admin/kcb/kcblist";
    }


    // 删除课程表列表操作
    @RequestMapping("/delkcb")
    public String delKcb (HttpServletRequest request) {
        int kcbid = Integer.parseInt(request.getParameter("keyid"));
        int ret = kcbService.delete(kcbid);
        if (ret > 0) {
            // 删除成功
            request.setAttribute("msg", "<script>alert('删除成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('删除失败');</script>");
        }

        return "redirect:/admin/kcblistpage";
    }


    // 课程表编辑界面
    @RequestMapping("/editkcb")
    public String editKcbPage (Model model,HttpServletRequest request) {

        // 获取所有的课程名称
        List<Kecheng> kechengList = kechengService.listAll();
        model.addAttribute("keList",kechengList);

        // 获取所有的课程时间
        List<Keshi> keshiList = keshiService.listAll();
        model.addAttribute("keshiList",keshiList);

        // 根据id获取课程表信息
        int kcbid = Integer.parseInt(request.getParameter("keyid"));
        Kcb kcb = kcbService.getById(kcbid);
        model.addAttribute("kcbid",kcb.getKcbid());
        model.addAttribute("kc",kcb.getKc());
        model.addAttribute("skdd",kcb.getSkdd());
        model.addAttribute("sksj",kcb.getSksj());
        model.addAttribute("sm",kcb.getSm());
        model.addAttribute("ks",kcb.getKs());
        return "/admin/kcb/kcbedit";
    }


    // 提交修改请求
    @PostMapping("/editkcb")
    public String editKcb (Kcb kcb,HttpServletRequest request) {
        int ret = kcbService.update(kcb);
        if (ret > 0) {
            // 修改成功
            request.setAttribute("msg", "<script>alert('修改成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('修改失败');</script>");
        }
        return "redirect:/admin/kcblistpage";
    }


    // 展示课程表详情
    @RequestMapping("/kcbdetail")
    public String kcbDetail (HttpServletRequest request,Model model) {
        int kcbid = Integer.parseInt(request.getParameter("keyid"));
        Kcb kcb = kcbService.getById(kcbid);
        model.addAttribute("kcbid",kcb.getKcbid());
        model.addAttribute("kc",kcb.getKc());
        model.addAttribute("skdd",kcb.getSkdd());
        model.addAttribute("sksj",kcb.getSksj());
        model.addAttribute("sm",kcb.getSm());
        model.addAttribute("ks",kcb.getKs());
        return "/admin/kcb/kcbdetail";
    }


    // 当前管理员的信息
    @RequestMapping("/userinfo")
    public String userInfo (HttpServletRequest request,Model model) {
        // 获取当前管理员的id
        Object glyid =  request.getSession().getAttribute("user_id");
        // System.out.println(glyid);

        Admin admin = adminService.getAdminById((Integer) glyid);

        String yhm = admin.getYhm();
        String mm = admin.getMm();
        String xm = admin.getXm();
        model.addAttribute("yhm", yhm);
        model.addAttribute("mm", mm);
        model.addAttribute("xm", xm);
        model.addAttribute("glyid", glyid);

         return "/admin/glydetail";
    }


}
