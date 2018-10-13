package com.ydj.springboot2.service;

import com.ydj.springboot2.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
@Service
public class UserService {

    private static Map<Integer, User> map;

    public Mono<ServerResponse> addUser(ServerRequest request) {
        System.out.println(request);
        Mono<User> userMono = request.bodyToMono(User.class);
        return null;
    }

    public Flux<User> findUserList() {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setName("yangdejun");
        user.setAge(25);
        list.add(user);
        return Flux.fromStream(list.stream());
    }
}
