package com.kloudvista.resttemplatedemo.infrastructure.address;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Getter
@Setter
public class ResGetAll {

    private List<ResponseAddress> addressList;
}
