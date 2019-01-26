package com.ydj.springboot2.handler;

import com.ydj.springboot2.entity.User;
import com.ydj.springboot2.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <p> Date             : 2018/10/8 </p>
 * <p> Module           : </p>
 * <p> Description      : </p>
 * <p> Remark           : </p>
 *
 * @author yangdejun
 * @version 1.0
 * <p>--------------------------------------------------------------</p>
 * <p>修改历史</p>
 * <p>    序号    日期    修改人    修改原因    </p>
 * <p>    1                                     </p>
 */
@Component
public class UserHandler {

    private static final Logger log = LoggerFactory.getLogger(UserHandler.class);

    @Autowired
    private UserService userService;

    public Mono<ServerResponse> getUserList(ServerRequest request) {
        Flux<User> userFlux = userService.findUserList();
        userFlux.subscribe(user -> log.info(user.toString()));
        return ServerResponse.ok().body(userFlux, User.class);
    }

}
