let MAGIC_API_VERSION_TEXT = process.env.VUE_APP_MA_VERSION
let MAGIC_API_VERSION = 'V' + MAGIC_API_VERSION_TEXT.replace(/\./g, '_')

const contants = {
  BASE_URL: '', //UI 对应的接口路径
  WEBSOCKET_SERVER: '', //WebSocket服务地址
  SERVER_URL: '', //接口对应的路径
  AUTO_SAVE: true, // 是否自动保存
  DECORATION_TIMEOUT: 10000,
  API_DEFAULT_METHOD: 'GET',
  MAGIC_API_VERSION_TEXT,
  MAGIC_API_VERSION,
  HEADER_REQUEST_SESSION: 'Magic-Request-Session',
  HEADER_REQUEST_BREAKPOINTS: 'Magic-Request-Breakpoints',
  HEADER_REQUEST_CONTINUE: 'Magic-Request-Continue',
  HEADER_REQUEST_STEP_INTO: 'Magic-Request-Step-Into',
  HEADER_RESPONSE_WITH_MAGIC_API: 'response-with-magic-api',
  HEADER_RESPONSE_MAGIC_CONTENT_TYPE: 'ma-content-type',
  HEADER_APPLICATION_STREAM: 'application/octet-stream',
  HEADER_CONTENT_DISPOSITION: 'ma-content-disposition',
  HEADER_MAGIC_TOKEN: 'magic-token',
  HEADER_MAGIC_TOKEN_VALUE: 'unauthorization',
  IGNORE_VERSION: 'ignore-version',
  RESPONSE_CODE_DEBUG: 1000,
  RESPONSE_CODE_SCRIPT_ERROR: -1000,
  RESPONSE_NO_PERMISSION: -10,
  DEFAULT_EXPAND: true,
  config: {}
}

export default contants
