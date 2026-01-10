package io.github.MarceloJoao.arquiteturaspring.montadora.configuration;

import io.github.MarceloJoao.arquiteturaspring.montadora.Motor;
import io.github.MarceloJoao.arquiteturaspring.montadora.TipoMotor;
import io.github.MarceloJoao.arquiteturaspring.montadora.api.Aspirado;
import io.github.MarceloJoao.arquiteturaspring.montadora.api.Eletrico;
import io.github.MarceloJoao.arquiteturaspring.montadora.api.Turbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class MontadoraConfiguration {

    @Bean
    @Aspirado
    public Motor motorAspirado(){
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setModelo("XPTO-0");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor;
    }

    @Bean
    @Eletrico
    public Motor motoreletrico(){
        var motor = new Motor();
        motor.setCavalos(110);
        motor.setCilindros(3);
        motor.setModelo("TH-40");
        motor.setLitragem(1.4);
        motor.setTipo(TipoMotor.ELETRICO);
        return motor;
    }

    @Bean
    @Turbo
    public Motor motorturbo(){
        var motor = new Motor();
        motor.setCavalos(180);
        motor.setCilindros(3);
        motor.setModelo("XPTO-01");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.TURBO);
        return motor;
    }

}
