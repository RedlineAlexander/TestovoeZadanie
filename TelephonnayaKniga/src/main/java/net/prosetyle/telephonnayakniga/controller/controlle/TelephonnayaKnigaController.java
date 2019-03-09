package net.prosetyle.telephonnayakniga.controller.controlle;

import net.prosetyle.telephonnayakniga.controller.entity.Telephonnaya_Kniga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import net.prosetyle.telephonnayakniga.controller.service.TelephonnayaKnigaService;

@Controller
public class TelephonnayaKnigaController {
    private TelephonnayaKnigaService telephonnayaKnigaService;

    @Autowired(required = true)
    @Qualifier(value = "telephonnayaKnigaService")
    public void setTelephonnayaKnigaService(TelephonnayaKnigaService telephonnayaKnigaService){this.telephonnayaKnigaService = telephonnayaKnigaService;}

    @RequestMapping(value = "telephonnayakniga", method = RequestMethod.GET)
    public String listTelephonnayaKniga(Model model){
        model.addAttribute("telephonnaya_kniga", new Telephonnaya_Kniga());
        model.addAttribute("listTelephonnayaKniga", this.telephonnayaKnigaService.listTelephonnayaKniga());

        return "telepnonnyeknigi";

    }


    @RequestMapping(value = "/telephonnaya_kniga/add", method = RequestMethod.POST)
    public String addTelephonnayaKniga(@ModelAttribute("Telephonnaya_kniga") Telephonnaya_Kniga telephonnaya_kniga){
        if(telephonnaya_kniga.getId() == 0){
            this.telephonnayaKnigaService.addTelephonnayaKniga(telephonnaya_kniga);
        }
        else{
            this.telephonnayaKnigaService.updateTelephonnayaKniga(telephonnaya_kniga);
        }
        return "redirect:/Telephonnaya_kniga";

    }
    @RequestMapping("/remove/{id}")
    public String removeTelephonnayaKniga(@PathVariable("id") Integer id ){
        this.telephonnayaKnigaService.removeTelephonnayaKniga(id);
        return "redirect:/Telephonnaya_kniga";
    }

    @RequestMapping("edit/{id}")
    public String editTelephonnayaKniga(@PathVariable("id") Integer id, Model model){
        model.addAttribute("telephonnaya_kniga", this.telephonnayaKnigaService.getTelephonnayaKnigaById(id));
        model.addAttribute("listTelephonnayaKniga", this.telephonnayaKnigaService.listTelephonnayaKniga());

        return "telepnonnyeknigi";

    }

    @RequestMapping("telephonnayaknigadata/{id}")
    public String telephonnayaKnigaData(@PathVariable("id") Integer id, Model model){
        model.addAttribute("telephonnaya_kniga", this.telephonnayaKnigaService.getTelephonnayaKnigaById(id));

        return "telephonnayaknigadata";
    }


}
