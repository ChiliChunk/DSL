package nicoLang.aspects;

import java.util.Map;
import nicoLang.FSM;
import nicoLang.NicoLangPackage;
import nicoLang.aspects.FSMAspect;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

@SuppressWarnings("all")
public class Interpreter {
  public static void main(final String[] args) {
    NicoLangPackage.eINSTANCE.getClass();
    Map<String, Object> _extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
    XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
    _extensionToFactoryMap.put("xmi", _xMIResourceFactoryImpl);
    Resource resource = new ResourceSetImpl().getResource(URI.createURI("/home/nicolas/Dev/workspace-gemoc-2/NicoLang/model/FSM.xmi"), true);
    EObject _get = resource.getContents().get(0);
    FSM myfsm = ((FSM) _get);
    FSMAspect.execute(myfsm);
  }
}
