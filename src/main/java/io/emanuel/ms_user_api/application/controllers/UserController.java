package io.emanuel.ms_user_api.application.controllers;

import io.emanuel.ms_user_api.application.controllers.docs.UserAPI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController implements UserAPI {

}
