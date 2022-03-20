package start.startspring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {

    @GetMapping("hello")
    public String Hello(Model model){ // 모델은 담아서 뷰로 넘겨주는 용도
        model.addAttribute("data", "hello!!!");
        return "hello"; // hello.html을 찾아서 렌더링해라는 뜻
    }

    @GetMapping("hello-mvc")
    public String HelloMvc(@RequestParam("name") String name, Model model){ //외부에서 파라메터를 받음
        model.addAttribute("name",name);
        return "hello-templete";
    }

    @GetMapping("hello-string")
    @ResponseBody // Http에서 헤더부와 바디부의 바디부에 이 데이터를 직접 넣어주겠다
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체를 넘김
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
