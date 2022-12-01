package com.newwebproject.API;

import com.newwebproject.DTO.NewDTO;
import com.newwebproject.Service.impl.Newservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Controller // để bt nó là 1 lớp API
@CrossOrigin
@RestController
public class NewApi {
    //@RequestMapping(value = "/new" , method = RequestMethod.POST)// API là new
    //@ResponseBody // là 1 anotation đn khi trả data ra client sẽ trả về dạng j (vd; như 1 list) chuyển data từ newDTO tháng các file json
    @Autowired
    private Newservice newService;

    @PostMapping(value = "/new")
    public NewDTO CreateNew(@RequestBody NewDTO model) //@RequestBody là đối tượng giúp nhận data từ client
    {
        return newService.save(model) ;
    }
    @PutMapping (value = "/new/{id}")//@PathVariable("id") để lấy đừng dẫn "/new/{id}"
    public NewDTO UpdateNew(@RequestBody NewDTO model , @PathVariable("id") long id) //@RequestBody là đối tượng giúp nhận data từ client
    {
        model.setId(id);
        return newService.save(model);
    }
    @DeleteMapping (value = "/new")
    public void DeleteNew(@RequestBody long[] ids) //@RequestBody là đối tượng giúp nhận data từ client
    {

    }
}
