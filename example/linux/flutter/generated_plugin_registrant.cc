//
//  Generated file. Do not edit.
//

// clang-format off

#include "generated_plugin_registrant.h"

#include <example_plugin/example_plugin.h>

void fl_register_plugins(FlPluginRegistry* registry) {
  g_autoptr(FlPluginRegistrar) example_plugin_registrar =
      fl_plugin_registry_get_registrar_for_plugin(registry, "ExamplePlugin");
  example_plugin_register_with_registrar(example_plugin_registrar);
}
