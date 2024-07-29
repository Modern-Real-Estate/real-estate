package com.loinguyen1905.realestate.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("${release.api.prefix}/users")
public class UserController {
    // @Autowired
    // private IUserService userService;

    // @GetMapping("/{username}")
    // public UserEntity getMethodName(
    //     @PathVariable("username") String username
    // ) {
    //     userEntity user = userService.handlegetUserByUsername(username);
    //     return user;
    // }
}