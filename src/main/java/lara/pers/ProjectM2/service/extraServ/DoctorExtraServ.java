package lara.pers.ProjectM2.service.extraServ;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DoctorExtraServ {

    public void printServ(){
        log.info("impresion desde DoctorExtraServ");
    }

}
