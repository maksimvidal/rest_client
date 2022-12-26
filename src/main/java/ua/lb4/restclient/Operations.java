package ua.lb4.restclient;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import ua.lb4.restclient.boo.CourierType;
import ua.lb4.restclient.boo.DeliveryType;
import java.util.List;

public interface Operations {

    static DeliveryType createDelivery(DeliveryType deliveryType, Client client) {
        WebTarget target = client.target(Link.URL + "deliveries");
        return target.request(MediaType.APPLICATION_XML)
                .accept(MediaType.TEXT_PLAIN_TYPE)
                .post(Entity.xml(deliveryType), DeliveryType.class);
    }

    static List<DeliveryType> getAllDeliveries(String id, Client client) {
        WebTarget target = client.target(Link.URL + "clients/" + id + "/deliveries");
        List<DeliveryType> deliveryTypes = target.request().get().readEntity(new GenericType<>(){});

        return deliveryTypes;
    }

    static DeliveryType cancelDelivery(String id, Client client) {
        WebTarget target = client.target(Link.URL + "deliveries/cancel/" + id);
        DeliveryType delivery = (target.request().delete().readEntity(DeliveryType.class));

        return delivery;
    }

    static DeliveryType updateDelivery(DeliveryType delivery, Client client) {
        WebTarget target = client.target(Link.URL + "deliveries");
        return target.request().put(Entity.xml(delivery), DeliveryType.class);
    }

    static DeliveryType assignCourier(String id, CourierType courier, Client client) {
        WebTarget target = client.target(Link.URL + "deliveries/couriers/" + id);
        return target.request().put(Entity.xml(courier), DeliveryType.class);
    }

}
