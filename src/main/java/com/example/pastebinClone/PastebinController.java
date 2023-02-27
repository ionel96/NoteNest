package com.example.pastebinClone;

import com.example.pastebinClone.entity.PastebinClone;
import com.example.pastebinClone.repository.PastebinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PastebinController {
    @Autowired
    private PastebinRepository pastebinRepository;

    @GetMapping("/paste")
    public String pasteForm(Model model) {
        model.addAttribute("paste", new PastebinClone());
        return "paste";
    }

    @PostMapping("/paste")
    public String addPaste(@ModelAttribute PastebinClone paste, Model model) {
        model.addAttribute("paste", paste);
        PastebinClone n = new PastebinClone();
        n.setText(paste.getText());
        n.setAuthor(paste.getAuthor());
        n.setDate(paste.getDate());
        pastebinRepository.save(n);
        return "result";
    }

    @GetMapping("/paste/list")
    public String seeAllPastes(Model model) {
        model.addAttribute("paste", pastebinRepository.findAll());
        return "list";
    }

    @GetMapping("/deletePaste/{id}")
    public String deletePasteId(@PathVariable(value = "id") long id) {
        pastebinRepository.deleteById(id);
        return "redirect:/paste/list";
    }
}