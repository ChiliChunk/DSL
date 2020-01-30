package nicoLang.aspects;

import java.util.Map;
import nicoLang.InitState;
import nicoLang.aspects.InitStateAspectInitStateAspectProperties;

@SuppressWarnings("all")
public class InitStateAspectInitStateAspectContext {
  public final static InitStateAspectInitStateAspectContext INSTANCE = new InitStateAspectInitStateAspectContext();
  
  public static InitStateAspectInitStateAspectProperties getSelf(final InitState _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new nicoLang.aspects.InitStateAspectInitStateAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<InitState, InitStateAspectInitStateAspectProperties> map = new java.util.WeakHashMap<nicoLang.InitState, nicoLang.aspects.InitStateAspectInitStateAspectProperties>();
  
  public Map<InitState, InitStateAspectInitStateAspectProperties> getMap() {
    return map;
  }
}
