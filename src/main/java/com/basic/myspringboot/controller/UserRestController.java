package com.basic.myspringboot.controller;

import com.basic.myspringboot.Service.UserService;
import com.basic.myspringboot.dto.UserReqDTO;
import com.basic.myspringboot.dto.UserResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;
//    인증 없이 볼 수 있는 거
@GetMapping("/welcome")
public String welcome() {
    return "Welcome this endpoint is not secure";
}

    @PostMapping
    public UserResDTO saveUser(@RequestBody UserReqDTO userReqDTO){

        return userService.saveUser(userReqDTO);
    }

    @GetMapping("/{id}")
    public UserResDTO getUserById(@PathVariable Long id){

        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserResDTO> getUsers(){
        return userService.getUsers();

    }

    @PutMapping("/{email}")
    public UserResDTO updateUser(@PathVariable String email, @RequestBody UserReqDTO userReqDTO){
        return userService.updateUser(email, userReqDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(id + " User가 삭제처리 되었습니다.");
    }
}
