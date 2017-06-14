package mijao;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IotController {
	
	@Autowired
	private IotService iotService;
	
	@RequestMapping("/sensores")
	public List<IotSensores> getAllIotSensores(){
		return iotService.getAllIotSensores();
	}
	
	@RequestMapping("/sensores/{id}")
	public IotSensores getIotSensores(@PathVariable String id){
		return iotService.getIotSensores(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/sensores")
	public void addIotSensores(@RequestBody IotSensores iotSensores){
		iotService.addIotSensores(iotSensores);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/sensores/{id}")
	public void updateIotSensores(@RequestBody IotSensores iotSensores, @PathVariable String id){
		iotService.updateIotSensores(id, iotSensores);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/sensores/{id}")
	public void deleteIotSensores(@PathVariable String id){
		iotService.deleteIotSensores(id);
	}
}
