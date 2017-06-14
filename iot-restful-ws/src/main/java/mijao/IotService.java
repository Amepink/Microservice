package mijao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class IotService {
	private	List<IotSensores> sensores = new ArrayList<>(Arrays.asList(
			new IotSensores("KY-002","sensor de movimiento","salio persona"),
			new IotSensores("KY-005","sensor de temperatura","incendio"),
			new IotSensores("KY-008","sensor de inundacion","baño inundado")
			));
	
	public List<IotSensores> getAllIotSensores(){
		return sensores;
	}
	
	public IotSensores getIotSensores(String id){
		return sensores.stream().filter(s -> s.getId().equals(id)).findFirst().get();
	}

	public void addIotSensores(IotSensores iotSensores) {
		sensores.add(iotSensores);
		
	}

	public void updateIotSensores(String id, IotSensores iotSensores) {
		for (int i = 0; i < sensores.size(); i++){
			IotSensores s = sensores.get(i);
			if(s.getId().equals(id)){
				sensores.set(i, iotSensores);
				return;
			}
		}
		
	}

	public void deleteIotSensores(String id) {
		sensores.removeIf(s -> s.getId().equals(id));
	}

}
