var { requireNativeComponent, PropTypes } = require('react-native');

var iface = {
  name: 'VideoView',
  propTypes: {
    streamUrl: PropTypes.string
  }
};

module.exports = requireNativeComponent('RCTVitamioView', iface);